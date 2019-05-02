package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.AnimationEpisode;
import com.acgnfuns.service.AnimationEpisodeService;
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
@RequestMapping(value = "/v1/animation")
@Api(tags = {"animationEpisode"})
public class AnimationEpisodeController extends AbstractRestHandler {

    @Autowired
    private AnimationEpisodeService animationEpisodeService;

    @RequestMapping(value = "/getAnimationEpisodeByBangumiUrl",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Episodes.", notes = "You have to provide a valid Bangumi url.")
    public
    @ResponseBody
    List<AnimationEpisode> getAnimationEpisodeListByBangumiUrl(@ApiParam(value = "The bangumiUrl of the Episode.", required = true)
                                         @RequestParam String bangumiUrl,
                                                               HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<AnimationEpisode> animationEpisode = this.animationEpisodeService.getAnimationEpisodeListByBangumiUrl(bangumiUrl);
        checkResourceFound(animationEpisode);
        //todo: http://goo.gl/6iNAkz
        return animationEpisode;
    }

    @RequestMapping(value = "/getAnimationEpisodeByEpisodeUrl",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single Episode.", notes = "You have to provide a valid Episode url.")
    public
    @ResponseBody
    AnimationEpisode getAnimationEpisodeByEpisodeUrl(@ApiParam(value = "The episodeUrl of the Episode.", required = true)
                                         @RequestParam String episodeUrl,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        AnimationEpisode animationEpisode = this.animationEpisodeService.getAnimationEpisodeByEpisodeUrl(episodeUrl);
        checkResourceFound(animationEpisode);
        //todo: http://goo.gl/6iNAkz
        return animationEpisode;
    }

}
