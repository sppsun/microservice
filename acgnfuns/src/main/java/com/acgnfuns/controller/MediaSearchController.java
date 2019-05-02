package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.MediaSearch;
import com.acgnfuns.service.MediaSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/v1/search")
@Api(tags = {"mediaSearch"})
public class MediaSearchController extends AbstractRestHandler {

    @Autowired
    private MediaSearchService mediaSearchService;

    @RequestMapping(value = "/getMediaSearchListByName",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get MediaSearchList.", notes = "You have to provide a valid media name.")
    public
    @ResponseBody
    List<MediaSearch> getMediaSearchListByName(@ApiParam(value = "The name of the media.", required = true)
                                         @RequestParam String name,
                                                               HttpServletRequest request, HttpServletResponse response) throws Exception {
        MediaSearch mediaSearch = new MediaSearch();
        mediaSearch.setName(name);
        List<MediaSearch> mediaSearchList = this.mediaSearchService.getMediaSearchListByName(mediaSearch.getName());
        checkResourceFound(mediaSearchList);
        //todo: http://goo.gl/6iNAkz
        return mediaSearchList;
    }

}
