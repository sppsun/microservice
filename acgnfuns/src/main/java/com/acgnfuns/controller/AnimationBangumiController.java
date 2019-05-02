package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.AnimationBangumi;
import com.acgnfuns.service.AnimationBangumiService;
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
@RequestMapping(value = "/v1/animation")
@Api(tags = {"animationBangumi"})
public class AnimationBangumiController extends AbstractRestHandler {

    @Autowired
    private AnimationBangumiService animationBangumiService;

    @RequestMapping(value = "/getAnimationBangumiList",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all bangumis.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<AnimationBangumi> getAnimationBangumiList(@ApiParam(value = "The page number (zero-based)", required = true, example = "0")
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                   @ApiParam(value = "Tha page size", required = true, example = "100")
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                   HttpServletRequest request, HttpServletResponse response) {
        return this.animationBangumiService.getAnimationBangumiList(page, size);
    }

    @RequestMapping(value = "/getAnimationBangumiByUrl",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single bangumi.", notes = "You have to provide a valid bangumi url.")
    public
    @ResponseBody
    AnimationBangumi getAnimationBangumiByUrl(@ApiParam(value = "The url of the bangumi.", required = true)
                                         @RequestParam String url,
                                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        AnimationBangumi animationBangumi = this.animationBangumiService.getAnimationBangumiByUrl(url);
        checkResourceFound(animationBangumi);
        return animationBangumi;
    }

}
