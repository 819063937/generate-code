package com.lyz.generate.dto;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/3 10:17
 */
public class TableColumnDto {
    /**
     * 数据库名称
     */
    private String tableSchema;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 字段名称
     */
    private String columnName;

    /**
     * 字段位置
     */
    private Integer ordinalPosition;

    /**
     * 列的默认值
     */
    private String columnDefault;

    /**
     * 是否允许为空
     */
    private String isNullable;

    /**
     * 字段类型
     */
    private String dataType;

    /**
     * 字段类型详情varchar(100)
     */
    private String columnType;

    /**
     * 是否为主键
     */
    private String columnKey;

    /**
     * 字段自增，自动修改说明
     */
    private String extra;

    /**
     * 字段说明
     */
    private String columnComment;

    /**
     * 字段对应的Java属性名
     */
    private String propertyName;
    /**
     * 字段类型对应的Java类型
     */
    private String propertyType;

    /**
     * 是否和父字段重复，true重复，false不重复
     */
    private boolean baseField;

    /**
     * 字段是否为主键，true为主键，false为非主键
     */
    private boolean idFlg;

    /**
     * 操作类型
     */
    private int operateType;

    /**
     * 是否允许更新false可以更新，true不允许更新，例如创建时间
     */
    private boolean updateFlg;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public boolean isBaseField() {
        return baseField;
    }

    public void setBaseField(boolean baseField) {
        this.baseField = baseField;
    }

    public boolean isIdFlg() {
        return idFlg;
    }

    public void setIdFlg(boolean idFlg) {
        this.idFlg = idFlg;
    }

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

    public boolean isUpdateFlg() {
        return updateFlg;
    }

    public void setUpdateFlg(boolean updateFlg) {
        this.updateFlg = updateFlg;
    }
}
