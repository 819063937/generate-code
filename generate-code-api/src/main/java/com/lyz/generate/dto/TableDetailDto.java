package com.lyz.generate.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/3 10:17
 */
public class TableDetailDto {
    /**
     *
     */
    private String tableCatalog;

    /**
     * 数据库名称
     */
    private String tableSchema;

    /**
     * 表名称
     */
    private String tableName;

    /**
     *
     */
    private String tableType;

    /**
     *
     */
    private String engine;

    /**
     *
     */
    private Integer version;

    /**
     *
     */
    private String rowFormat;

    /**
     *
     */
    private Long tableRows;

    /**
     *
     */
    private Long avgRowLength;

    /**
     *
     */
    private Long dataLength;

    /**
     *
     */
    private Long maxDataLength;

    /**
     *
     */
    private Long indexLength;

    /**
     *
     */
    private Long dataFree;

    /**
     *
     */
    private Long autoIncrement;

    /**
     * 表创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkTime;

    /**
     *
     */
    private String tableCollation;

    /**
     *
     */
    private Long checksum;

    /**
     *
     */
    private String createOptions;

    /**
     * 表说明
     */
    private String tableComment;

    /**
     * 模块名称首字母大写
     */
    private String tableModuleName;

    /**
     * 模块名称首字母小写
     */
    private String tableModuleName2;

    /**
     * 主键字段
     */
    private TableColumnDto priColumn;

    /**
     * 删除字段
     */
    private TableColumnDto deleteColumn;

    /**
     * 最后更新人字段
     */
    private TableColumnDto updateUserColumn;

    /**
     * 最后更新时间字段
     */
    private TableColumnDto updateTimeColumn;

    /**
     * 字段是否包含date类型
     */
    private boolean dateFlg;

    /**
     * 字段是否包含bigDecimal类型
     */
    private boolean bigDecimalFlg;

    /**
     * 类是否需要date类型
     */
    private boolean classDateFlg;

    /**
     * 主键id是否自增
     */
    private boolean autoIncrementFlg;

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

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

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
    }

    public Long getTableRows() {
        return tableRows;
    }

    public void setTableRows(Long tableRows) {
        this.tableRows = tableRows;
    }

    public Long getAvgRowLength() {
        return avgRowLength;
    }

    public void setAvgRowLength(Long avgRowLength) {
        this.avgRowLength = avgRowLength;
    }

    public Long getDataLength() {
        return dataLength;
    }

    public void setDataLength(Long dataLength) {
        this.dataLength = dataLength;
    }

    public Long getMaxDataLength() {
        return maxDataLength;
    }

    public void setMaxDataLength(Long maxDataLength) {
        this.maxDataLength = maxDataLength;
    }

    public Long getIndexLength() {
        return indexLength;
    }

    public void setIndexLength(Long indexLength) {
        this.indexLength = indexLength;
    }

    public Long getDataFree() {
        return dataFree;
    }

    public void setDataFree(Long dataFree) {
        this.dataFree = dataFree;
    }

    public Long getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(Long autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getTableCollation() {
        return tableCollation;
    }

    public void setTableCollation(String tableCollation) {
        this.tableCollation = tableCollation;
    }

    public Long getChecksum() {
        return checksum;
    }

    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }

    public String getCreateOptions() {
        return createOptions;
    }

    public void setCreateOptions(String createOptions) {
        this.createOptions = createOptions;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getTableModuleName() {
        return tableModuleName;
    }

    public void setTableModuleName(String tableModuleName) {
        this.tableModuleName = tableModuleName;
    }

    public String getTableModuleName2() {
        return tableModuleName2;
    }

    public void setTableModuleName2(String tableModuleName2) {
        this.tableModuleName2 = tableModuleName2;
    }

    public TableColumnDto getPriColumn() {
        return priColumn;
    }

    public void setPriColumn(TableColumnDto priColumn) {
        this.priColumn = priColumn;
    }

    public TableColumnDto getDeleteColumn() {
        return deleteColumn;
    }

    public void setDeleteColumn(TableColumnDto deleteColumn) {
        this.deleteColumn = deleteColumn;
    }

    public TableColumnDto getUpdateUserColumn() {
        return updateUserColumn;
    }

    public void setUpdateUserColumn(TableColumnDto updateUserColumn) {
        this.updateUserColumn = updateUserColumn;
    }

    public TableColumnDto getUpdateTimeColumn() {
        return updateTimeColumn;
    }

    public void setUpdateTimeColumn(TableColumnDto updateTimeColumn) {
        this.updateTimeColumn = updateTimeColumn;
    }

    public boolean isDateFlg() {
        return dateFlg;
    }

    public void setDateFlg(boolean dateFlg) {
        this.dateFlg = dateFlg;
    }

    public boolean isBigDecimalFlg() {
        return bigDecimalFlg;
    }

    public void setBigDecimalFlg(boolean bigDecimalFlg) {
        this.bigDecimalFlg = bigDecimalFlg;
    }

    public boolean isClassDateFlg() {
        return classDateFlg;
    }

    public void setClassDateFlg(boolean classDateFlg) {
        this.classDateFlg = classDateFlg;
    }

    public boolean isAutoIncrementFlg() {
        return autoIncrementFlg;
    }

    public void setAutoIncrementFlg(boolean autoIncrementFlg) {
        this.autoIncrementFlg = autoIncrementFlg;
    }
}
