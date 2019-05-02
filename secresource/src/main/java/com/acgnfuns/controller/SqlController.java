package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.Sql;
import com.acgnfuns.service.SqlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/v1/sql")
@Api(tags = {"sql"})
public class SqlController extends AbstractRestHandler {

    @Autowired
    private SqlService sqlService;

    @RequestMapping(value = "/selectOne", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "selectOne.", notes = "You can selectOne.")
    public
    @ResponseBody
    Map<String, Object> selectOne(@ApiParam(value = "The params of sql.", required = true) @RequestBody Sql sql,
                                       HttpServletRequest request, HttpServletResponse response) throws Exception {
        return sqlService.selectOne(sql.getSql(), sql.getParams());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "insert.", notes = "You can insert.")
    public
    @ResponseBody
    int insert(@ApiParam(value = "The params of sql.", required = true) @RequestBody Sql sql,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        return sqlService.insert(sql.getSql(), sql.getParams());
    }

}
