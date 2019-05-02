package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.License;
import com.acgnfuns.service.LicenseService;
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
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
@Api(tags = {"licenses"})
public class LicenseController extends AbstractRestHandler {

    @Autowired
    private LicenseService licenseService;

    @RequestMapping(value="/{licenseId}/{clientType}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getLicensesWithClient", notes = "getLicensesWithClient")
    public
    @ResponseBody
    License getLicensesWithClient(@ApiParam(value = "organizationId", required = true, example = "") @PathVariable("organizationId") String organizationId,
                                  @ApiParam(value = "licenseId", required = true, example = "") @PathVariable("licenseId") String licenseId,
                                  @ApiParam(value = "clientType", required = true, example = "") @PathVariable("clientType") String clientType,
                                         HttpServletRequest request, HttpServletResponse response) {

        return licenseService.getLicense(organizationId,licenseId, clientType);
    }

    @RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getLicenses", notes = "getLicenses")
    public
    @ResponseBody
    License getLicenses(@ApiParam(value = "organizationId", required = true, example = "") @PathVariable("organizationId") String organizationId,
                        @ApiParam(value = "licenseId", required = true, example = "") @PathVariable("licenseId") String licenseId,
                        HttpServletRequest request, HttpServletResponse response) {
        return licenseService.getLicense(organizationId, licenseId);
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getLicenses", notes = "getLicenses")
    public
    @ResponseBody
    List<License> getLicenses(@ApiParam(value = "organizationId", required = true, example = "") @PathVariable("organizationId") String organizationId) {
        return licenseService.getLicensesByOrg(organizationId);
    }
}
