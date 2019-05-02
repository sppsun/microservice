package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.Clicks;
import com.acgnfuns.service.ClicksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/v1/clicks")
@Api(tags = {"clicks"})
public class ClicksController extends AbstractRestHandler {

    @Autowired
    private ClicksService clicksService;

    @RequestMapping(value = "/getClicksList",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all clicks.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Clicks> getClicksList(
            @ApiParam(value = "The page number (zero-based)", required = true, example = "0")
            @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
            @ApiParam(value = "Tha page size", required = true, example = "100")
            @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
            @ApiParam(value = "Tha media type", required = true, example = "动画")
            @RequestParam(value = "type", required = true, defaultValue = "动画") String type,
            HttpServletRequest request, HttpServletResponse response)
    {
        return this.clicksService.getClicksList(page, size, type);
    }
}
