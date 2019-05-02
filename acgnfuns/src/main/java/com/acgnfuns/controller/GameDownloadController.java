package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.GameDownload;
import com.acgnfuns.service.GameDownloadService;
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
@RequestMapping(value = "/v1/game")
@Api(tags = {"gameDownload"})
public class GameDownloadController extends AbstractRestHandler {

    @Autowired
    private GameDownloadService gameDownloadService;

    @RequestMapping(value = "/getGameDownloadListByGeimuUrl",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get geimus.", notes = "You have to provide a valid geimu url.")
    public
    @ResponseBody
    List<GameDownload> getGameDownloadListByGeimuUrl(@ApiParam(value = "The geimuUrl of the geimu.", required = true)
                                         @RequestParam String geimuUrl,
                                                               HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<GameDownload> gameDownload = this.gameDownloadService.getGameDownloadListByGeimuUrl(geimuUrl);
        checkResourceFound(gameDownload);
        //todo: http://goo.gl/6iNAkz
        return gameDownload;
    }

    @RequestMapping(value = "/getGameDownloadByDownloadUrl",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single download.", notes = "You have to provide a valid download url.")
    public
    @ResponseBody
    GameDownload getGameDownloadByDownloadUrl(@ApiParam(value = "The downloadUrl of the download.", required = true)
                                         @RequestParam String downloadUrl,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        GameDownload gameDownload = this.gameDownloadService.getGameDownloadByDownloadUrl(downloadUrl);
        checkResourceFound(gameDownload);
        //todo: http://goo.gl/6iNAkz
        return gameDownload;
    }

}
