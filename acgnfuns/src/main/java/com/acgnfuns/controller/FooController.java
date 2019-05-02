package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.service.ClicksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RefreshScope
@RequestMapping(value = "/v1/foo")
@Api(tags = {"foo"})
public class FooController extends AbstractRestHandler {

    @Autowired
    private ClicksService clicksService;

    @Value("${foo}")
    private String foo;
    @RequestMapping(value = "/sayHi",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "sayHi", notes = "sayHi")
    public
    @ResponseBody
    String sayHi(HttpServletRequest request, HttpServletResponse response) {
        return foo;
    }
}
