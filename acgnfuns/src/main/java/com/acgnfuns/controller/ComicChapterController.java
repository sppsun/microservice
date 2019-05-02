package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.ComicChapter;
import com.acgnfuns.service.ComicChapterService;
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
@RequestMapping(value = "/v1/comic")
@Api(tags = {"comicChapter"})
public class ComicChapterController extends AbstractRestHandler {

    @Autowired
    private ComicChapterService comicChapterService;

    @RequestMapping(value = "/getComicChapterListByMangaUrl",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get chapters.", notes = "You have to provide a valid manga url.")
    public
    @ResponseBody
    List<ComicChapter> getComicChapterListByMangaUrl(@ApiParam(value = "The mangaUrl of the chapter.", required = true)
                                         @RequestParam String mangaUrl,
                                                               HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<ComicChapter> comicChapter = this.comicChapterService.getComicChapterListByMangaUrl(mangaUrl);
        checkResourceFound(comicChapter);
        //todo: http://goo.gl/6iNAkz
        return comicChapter;
    }

    @RequestMapping(value = "/getComicChapterByChapterUrl",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single chapter.", notes = "You have to provide a valid chapter url.")
    public
    @ResponseBody
    ComicChapter getComicChapterByChapterUrl(@ApiParam(value = "The chapterUrl of the chapter.", required = true)
                                         @RequestParam String chapterUrl,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        ComicChapter comicChapter = this.comicChapterService.getComicChapterByChapterUrl(chapterUrl);
        checkResourceFound(comicChapter);
        //todo: http://goo.gl/6iNAkz
        return comicChapter;
    }

}
