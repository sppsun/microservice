package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.Organization;
import com.acgnfuns.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value="v1/organizations")
@Api(tags = {"organizations"})
public class OrganizationController extends AbstractRestHandler {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getOrganization", notes = "getOrganization")
    public
    @ResponseBody
    Organization getOrganization(@ApiParam(value = "organizationId", required = true, example = "") @PathVariable("organizationId") String organizationId,
                                 HttpServletRequest request, HttpServletResponse response) {
        return organizationService.getOrg(organizationId);
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "updateOrganization", notes = "updateOrganization")
    public
    @ResponseBody
    void updateOrganization(@ApiParam(value = "organizationId", required = true, example = "") @PathVariable("organizationId") String orgId,
                            @ApiParam(value = "org", required = true) @RequestBody Organization org,
                            HttpServletRequest request, HttpServletResponse response) {
        organizationService.updateOrg( org );
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "saveOrganization", notes = "saveOrganization")
    public
    @ResponseBody
    void saveOrganization(@ApiParam(value = "org", required = true) @RequestBody Organization org,
                          HttpServletRequest request, HttpServletResponse response) {
        organizationService.saveOrg( org );
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "deleteOrganization", notes = "deleteOrganization")
    public
    @ResponseBody
    void deleteOrganization(@ApiParam(value = "orgId", required = true) @PathVariable("orgId") String orgId,
                            @ApiParam(value = "org", required = true) @RequestBody Organization org,
                             HttpServletRequest request, HttpServletResponse response) {
        organizationService.deleteOrg( org );
    }

}
