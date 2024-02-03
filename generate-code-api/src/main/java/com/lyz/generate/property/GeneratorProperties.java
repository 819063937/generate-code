package com.lyz.generate.property;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/3 10:26
 */
@Component
@ConfigurationProperties(prefix = "generator")
public class GeneratorProperties {
    /**
     * 数据库名称
     */
    private String tableSchema;

    /**
     * 控制层服务层包名
     */
    private String packageName;

    /**
     * 对象实体类包名
     */
    private String entityPackageName;

    /**
     * 作者
     */
    private String author;

    /**
     * 是否属于子模块，true是，false否
     */
    private boolean subModule;

    /**
     * 子模块名称
     */
    private String subModuleName;

    /**
     * 是否引用父类
     */
    private boolean baseEntity;

    /**
     * 父类字段
     */
    private String baseField;

    /**
     * 逻辑删除字段
     */
    private String deleteColumn;

    /**
     * 逻辑删除值
     */
    private String deleteValue;

    /**
     * 最后更新人字段
     */
    private String updateUserColumn;

    /**
     * 最后更新时间字段
     */
    private String updateTimeColumn;

    /**
     * 是否加@EqualsAndHashCode注解，true加，false不加
     */
    private boolean callSuper;

    /**
     * 不允许更新的字段
     */
    private String notUpdate;

    /**
     * 是否去除表的前缀
     */
    private boolean tablePrefix;

    /**
     * 要去除表的前缀字段
     */
    private List<String> tablePrefixs;
    /**
     * 是否去除的前缀字段
     */
    private boolean columnPrefix;

    /**
     * 要去除的前缀字段
     */
    private List<String> columnPrefixs;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getEntityPackageName() {
        return entityPackageName;
    }

    public void setEntityPackageName(String entityPackageName) {
        this.entityPackageName = entityPackageName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isSubModule() {
        return subModule;
    }

    public void setSubModule(boolean subModule) {
        this.subModule = subModule;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public boolean isBaseEntity() {
        return baseEntity;
    }

    public void setBaseEntity(boolean baseEntity) {
        this.baseEntity = baseEntity;
    }

    public String getBaseField() {
        return baseField;
    }

    public void setBaseField(String baseField) {
        this.baseField = baseField;
    }

    public String getDeleteColumn() {
        return deleteColumn;
    }

    public void setDeleteColumn(String deleteColumn) {
        this.deleteColumn = deleteColumn;
    }

    public String getDeleteValue() {
        return deleteValue;
    }

    public void setDeleteValue(String deleteValue) {
        this.deleteValue = deleteValue;
    }

    public String getUpdateUserColumn() {
        return updateUserColumn;
    }

    public void setUpdateUserColumn(String updateUserColumn) {
        this.updateUserColumn = updateUserColumn;
    }

    public String getUpdateTimeColumn() {
        return updateTimeColumn;
    }

    public void setUpdateTimeColumn(String updateTimeColumn) {
        this.updateTimeColumn = updateTimeColumn;
    }

    public boolean isCallSuper() {
        return callSuper;
    }

    public void setCallSuper(boolean callSuper) {
        this.callSuper = callSuper;
    }

    public String getNotUpdate() {
        return notUpdate;
    }

    public void setNotUpdate(String notUpdate) {
        this.notUpdate = notUpdate;
    }

    public boolean isTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(boolean tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public List<String> getTablePrefixs() {
        return tablePrefixs;
    }

    public void setTablePrefixs(List<String> tablePrefixs) {
        this.tablePrefixs = tablePrefixs;
    }

    public boolean isColumnPrefix() {
        return columnPrefix;
    }

    public void setColumnPrefix(boolean columnPrefix) {
        this.columnPrefix = columnPrefix;
    }

    public List<String> getColumnPrefixs() {
        return columnPrefixs;
    }

    public void setColumnPrefixs(List<String> columnPrefixs) {
        this.columnPrefixs = columnPrefixs;
    }
}
