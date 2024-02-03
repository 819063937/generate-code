package com.lyz.generate.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lyz.generate.dto.TableColumnDto;
import com.lyz.generate.dto.TableDetailDto;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/3 10:16
 */
@Repository
public interface DbMapper {

    /**
     * 获取当前连接数据库名称
     * 
     * @return String
     */
    String queryDataBase();

    /**
     * 查询表的信息
     *
     * @param tableSchema 库名
     * @param tableName 表名
     * @return TableDetailDto
     */
    TableDetailDto queryTableDetail(@Param("tableSchema") String tableSchema, @Param("tableName") String tableName);

    /**
     * 查询表字段的详细信息
     *
     * @param tableSchema 库名
     * @param tableName 表名
     * @return List<TableColumnDto>
     */
    List<TableColumnDto> queryTableColumns(@Param("tableSchema") String tableSchema,
        @Param("tableName") String tableName);

    /**
     * 查询表的信息集合
     *
     * @param map 库名
     * @return List<TableDetailDto>
     */
    List<TableDetailDto> queryTableList(Map<String, Object> map);
}
