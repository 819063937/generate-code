package com.lyz.generate.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyz.generate.dto.TableDetailDto;
import com.lyz.generate.service.ToolService;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/3 10:14
 */
@RestController
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private ToolService toolService;

    /**
     * 查询表信息可分页
     * 
     * @param map
     * @return List
     */
    @PostMapping("/table/query")
    public List<TableDetailDto> queryTableList(@RequestBody Map<String, Object> map) {
        return toolService.queryTableList(map);
    }

    /**
     * 下载生成代码接口
     * 
     * @param response
     * @param tableNames 表名，可以多个逗号分割
     */
    @GetMapping("/download/{tableNames}")
    public void download(HttpServletResponse response, @PathVariable("tableNames") String tableNames) {
        toolService.download(response, tableNames);
    }

}
