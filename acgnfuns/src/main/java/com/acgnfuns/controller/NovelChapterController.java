package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.NovelChapter;
import com.acgnfuns.service.NovelChapterService;
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
@RequestMapping(value = "/v1/novel")
@Api(tags = {"novelChapter"})
public class NovelChapterController extends AbstractRestHandler {

    @Autowired
    private NovelChapterService novelChapterService;

    @RequestMapping(value = "/getNovelChapterListByNoberuUrl",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Chapters.", notes = "You have to provide a valid Chapter url.")
    public
    @ResponseBody
    List<NovelChapter> getNovelChapterListByNoberuUrl(@ApiParam(value = "The noberuUrl of the Chapter.", required = true)
                                         @RequestParam String noberuUrl,
                                                               HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<NovelChapter> novelChapter = this.novelChapterService.getNovelChapterListByNoberuUrl(noberuUrl);
        checkResourceFound(novelChapter);
        //todo: http://goo.gl/6iNAkz
        return novelChapter;
    }

    @RequestMapping(value = "/getNovelChapterByChapterUrl",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single Chapter.", notes = "You have to provide a valid Chapter url.")
    public
    @ResponseBody
    NovelChapter getNovelChapterByChapterUrl(@ApiParam(value = "The chapterUrl of the Chapter.", required = true)
                                         @RequestParam String chapterUrl,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        NovelChapter novelChapter = this.novelChapterService.getNovelChapterByChapterUrl(chapterUrl);
        checkResourceFound(novelChapter);
        //todo: http://goo.gl/6iNAkz
        return novelChapter;
    }

}
