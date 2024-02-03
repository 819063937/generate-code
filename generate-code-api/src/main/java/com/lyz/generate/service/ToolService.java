package com.lyz.generate.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.lyz.generate.dto.TableDetailDto;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/3 10:14
 */
public interface ToolService {
    /**
     * 查询表的信息集合
     *
     * @param map 库名
     * @return List<TableDetailDto>
     */
    List<TableDetailDto> queryTableList(Map<String, Object> map);

    /**
     * 下载生成代码
     *
     * @param response
     * @param tableNames 表名，可以多个逗号分割
     */
    void download(HttpServletResponse response, String tableNames);

}
