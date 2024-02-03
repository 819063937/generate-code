package com.lyz.generate.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyz.generate.dto.TableColumnDto;
import com.lyz.generate.dto.TableDetailDto;
import com.lyz.generate.mapper.DbMapper;
import com.lyz.generate.property.GeneratorProperties;
import com.lyz.generate.service.ToolService;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/3 10:15
 */
@Service
public class ToolServiceImpl implements ToolService {

    private final static String TABLE_UNDERLINE = "_";

    private static final Map<String, String> PROPERTY_TYPE_MAP = new HashMap();

    private static final Map<String, String> TEMPLATE_NAME_MAP = new HashMap<>();

    private static final List<String> TEMPLATES = new ArrayList<>();

    static {
        TEMPLATES.add("template/mybatis/controller.java.vm");
        TEMPLATES.add("template/mybatis/entity.java.vm");
        TEMPLATES.add("template/mybatis/mapper.java.vm");
        TEMPLATES.add("template/mybatis/mapper.xml.vm");
        TEMPLATES.add("template/mybatis/service.java.vm");
        TEMPLATES.add("template/mybatis/serviceImpl.java.vm");
        TEMPLATES.add("template/mybatis-plus/controller.java.vm");
        TEMPLATES.add("template/mybatis-plus/entity.java.vm");
        TEMPLATES.add("template/mybatis-plus/mapper.java.vm");
        TEMPLATES.add("template/mybatis-plus/mapper.xml.vm");
        TEMPLATES.add("template/mybatis-plus/service.java.vm");
        TEMPLATES.add("template/mybatis-plus/serviceImpl.java.vm");

        TEMPLATE_NAME_MAP.put("template/mybatis/controller.java.vm",
            "mybatis/main/java/${generator.packageName}/controller/${generator.subModuleName}${moduleName}Controller.java");
        TEMPLATE_NAME_MAP.put("template/mybatis/entity.java.vm",
            "mybatis/main/java/${generator.entityPackageName}/entity/${generator.subModuleName}${moduleName}Entity.java");
        TEMPLATE_NAME_MAP.put("template/mybatis/mapper.java.vm",
            "mybatis/main/java/${generator.packageName}/mapper/${generator.subModuleName}${moduleName}Mapper.java");
        TEMPLATE_NAME_MAP.put("template/mybatis/mapper.xml.vm",
            "mybatis/main/resources/mapper/${generator.subModuleName}${moduleName}Mapper.xml");
        TEMPLATE_NAME_MAP.put("template/mybatis/service.java.vm",
            "mybatis/main/java/${generator.packageName}/service/${generator.subModuleName}${moduleName}Service.java");
        TEMPLATE_NAME_MAP.put("template/mybatis/serviceImpl.java.vm",
            "mybatis/main/java/${generator.packageName}/service/${generator.subModuleName}impl/${moduleName}ServiceImpl.java");
        TEMPLATE_NAME_MAP.put("template/mybatis-plus/controller.java.vm",
            "mybatis-plus/main/java/${generator.packageName}/controller/${generator.subModuleName}${moduleName}Controller.java");
        TEMPLATE_NAME_MAP.put("template/mybatis-plus/entity.java.vm",
            "mybatis-plus/main/java/${generator.entityPackageName}/entity/${generator.subModuleName}${moduleName}Entity.java");
        TEMPLATE_NAME_MAP.put("template/mybatis-plus/mapper.java.vm",
            "mybatis-plus/main/java/${generator.packageName}/mapper/${generator.subModuleName}${moduleName}Mapper.java");
        TEMPLATE_NAME_MAP.put("template/mybatis-plus/mapper.xml.vm",
            "mybatis-plus/main/resources/mapper/${generator.subModuleName}${moduleName}Mapper.xml");
        TEMPLATE_NAME_MAP.put("template/mybatis-plus/service.java.vm",
            "mybatis-plus/main/java/${generator.packageName}/service/${generator.subModuleName}${moduleName}Service.java");
        TEMPLATE_NAME_MAP.put("template/mybatis-plus/serviceImpl.java.vm",
            "mybatis-plus/main/java/${generator.packageName}/service/${generator.subModuleName}impl/${moduleName}ServiceImpl.java");

        PROPERTY_TYPE_MAP.put("bigint", "Long");
        PROPERTY_TYPE_MAP.put("tinyint", "Integer");
        PROPERTY_TYPE_MAP.put("smallint", "Integer");
        PROPERTY_TYPE_MAP.put("mediumint", "Integer");
        PROPERTY_TYPE_MAP.put("int", "Integer");
        PROPERTY_TYPE_MAP.put("integer", "Integer");
        PROPERTY_TYPE_MAP.put("date", "Date");
        PROPERTY_TYPE_MAP.put("datetime", "Date");
        PROPERTY_TYPE_MAP.put("timestamp", "Date");
        PROPERTY_TYPE_MAP.put("decimal", "BigDecimal");

        Properties properties = new Properties();
        properties.setProperty("resource.loader.file.class",
            "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty(Velocity.INPUT_ENCODING, "utf-8");
        Velocity.init(properties);
    }

    @Autowired
    private GeneratorProperties generatorProperties;

    @Autowired
    private DbMapper dbMapper;

    @Override
    public List<TableDetailDto> queryTableList(Map<String, Object> map) {
        map.put("tableSchema", getTableSchema());
        return dbMapper.queryTableList(map);
    }

    @Override
    public void download(HttpServletResponse response, String tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        getTableSchema();
        Map<String, Object> map = new HashMap<>();
        map.put("generator", generatorProperties);
        map.put("date", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        String[] tableNameArr = tableNames.split(",");
        for (String tableName : tableNameArr) {
            TableDetailDto tableDetail = dbMapper.queryTableDetail(generatorProperties.getTableSchema(), tableName);
            if (tableDetail == null) {
                continue;
            }
            List<TableColumnDto> tableColumns =
                dbMapper.queryTableColumns(generatorProperties.getTableSchema(), tableName);
            if (tableColumns.isEmpty()) {
                continue;
            }
            dealTable(tableDetail, tableColumns);
            map.put("table", tableDetail);
            map.put("fields", tableColumns);
            VelocityContext context = new VelocityContext(map);
            for (String template : TEMPLATES) {
                StringWriter sw = new StringWriter();
                Template tpl = Velocity.getTemplate(template, "utf-8");
                tpl.merge(context, sw);
                try {
                    zip.putNextEntry(new ZipEntry(getModuleFileName(template, tableDetail.getTableModuleName())));
                    IOUtils.write(sw.toString(), zip, "utf-8");
                    IOUtils.closeQuietly(sw);
                    zip.closeEntry();
                } catch (IOException e) {
                    System.out.println(" IOException " + e);
                }
            }
        }
        IOUtils.closeQuietly(zip);
        byte[] data = outputStream.toByteArray();
        try {
            response.reset();
            response.addHeader("Content-Disposition",
                "attachment; filename=" + URLEncoder.encode(tableNames + ".zip", "utf-8"));
            response.addHeader("Content-Length", "" + data.length);
            response.setContentType("application/octet-stream; charset=UTF-8");
            IOUtils.write(data, response.getOutputStream());
        } catch (IOException e) {
            System.out.println(" IOException " + e);
        }
    }

    private String getTableSchema() {
        if (generatorProperties.getTableSchema() == null || generatorProperties.getTableSchema().length() == 0) {
            generatorProperties.setTableSchema(dbMapper.queryDataBase());
        }
        return generatorProperties.getTableSchema();
    }

    private void dealTable(TableDetailDto tableDetail, List<TableColumnDto> tableColumns) {
        String tableName = tableDetail.getTableName().toLowerCase();
        if (generatorProperties.isTablePrefix()) {
            for (String prefix : generatorProperties.getTablePrefixs()) {
                if (tableName.startsWith(prefix)) {
                    tableName = tableName.substring(prefix.length());
                }
            }
        }
        tableName = String.valueOf(tableName.charAt(0)).toUpperCase() + tableName.substring(1);
        while (tableName.contains(TABLE_UNDERLINE)) {
            int index = tableName.indexOf(TABLE_UNDERLINE);
            tableName = tableName.substring(0, index) + String.valueOf(tableName.charAt(index + 1)).toUpperCase()
                + tableName.substring(index + 2);
        }
        tableDetail.setTableModuleName(tableName);
        tableDetail.setTableModuleName2(String.valueOf(tableName.charAt(0)).toLowerCase() + tableName.substring(1));

        boolean idFlg = false;
        boolean classDateFlg = false;
        for (TableColumnDto columnDto : tableColumns) {
            String propertyName = columnDto.getColumnName().toLowerCase();
            if (generatorProperties.isColumnPrefix()) {
                for (String prefix : generatorProperties.getColumnPrefixs()) {
                    if (propertyName.startsWith(prefix)) {
                        propertyName = propertyName.substring(prefix.length());
                    }
                }
            }
            while (propertyName.contains(TABLE_UNDERLINE)) {
                int index = propertyName.indexOf(TABLE_UNDERLINE);
                propertyName = propertyName.substring(0, index)
                    + String.valueOf(propertyName.charAt(index + 1)).toUpperCase() + propertyName.substring(index + 2);
            }

            columnDto.setPropertyName(propertyName);
            columnDto.setPropertyType(PROPERTY_TYPE_MAP.getOrDefault(columnDto.getDataType(), "String"));
            // 父类字段是否包含
            if (generatorProperties.isBaseEntity()
                && generatorProperties.getBaseField().contains(columnDto.getPropertyName() + ",")) {
                columnDto.setBaseField(true);
            } else {
                if ("Date".equals(columnDto.getPropertyType())) {
                    tableDetail.setDateFlg(true);
                } else if ("BigDecimal".equals(columnDto.getPropertyType())) {
                    tableDetail.setBigDecimalFlg(true);
                }
            }
            columnDto
                .setUpdateFlg((generatorProperties.getNotUpdate() + ",").contains(columnDto.getPropertyName() + ","));
            if ("String".equals(columnDto.getPropertyType())) {
                columnDto.setOperateType(1);
            } else if ("Long".equals(columnDto.getPropertyType()) || "Integer".equals(columnDto.getPropertyType())) {
                columnDto.setOperateType(2);
            } else if ("Date".equals(columnDto.getPropertyType())) {
                columnDto.setOperateType(3);
            }

            if (!idFlg && "PRI".equals(columnDto.getColumnKey())) {
                columnDto.setIdFlg(true);
                idFlg = true;
                tableDetail.setPriColumn(columnDto);
                if ("auto_increment".equalsIgnoreCase(columnDto.getExtra())) {
                    tableDetail.setAutoIncrementFlg(true);
                }
            }
            if (generatorProperties.getDeleteColumn().equalsIgnoreCase(columnDto.getColumnName())) {
                tableDetail.setDeleteColumn(columnDto);
            }
            if (generatorProperties.getUpdateUserColumn().equalsIgnoreCase(columnDto.getColumnName())) {
                tableDetail.setUpdateUserColumn(columnDto);
            }
            if (generatorProperties.getUpdateTimeColumn().equalsIgnoreCase(columnDto.getColumnName())) {
                tableDetail.setUpdateTimeColumn(columnDto);
                if ("Date".equals(columnDto.getPropertyType())) {
                    classDateFlg = true;
                }
            }
        }
        if (tableDetail.getDeleteColumn() != null) {
            tableDetail.setClassDateFlg(classDateFlg);
        }
        if (!idFlg) {
            tableDetail.setPriColumn(tableColumns.get(0));
        }
    }

    private String getModuleFileName(String template, String moduleName) {
        String result = TEMPLATE_NAME_MAP.getOrDefault(template, template).replace("${moduleName}", moduleName)
            .replace("${generator.entityPackageName}", generatorProperties.getEntityPackageName().replace(".", "/"))
            .replace("${generator.packageName}", generatorProperties.getPackageName().replace(".", "/"));
        String subModuleName = generatorProperties.isSubModule() ? generatorProperties.getSubModuleName() + "/" : "";
        result = result.replace("${generator.subModuleName}", subModuleName);
        return result;
    }
}
