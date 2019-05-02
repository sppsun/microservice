package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.Carousel;
import com.acgnfuns.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/v1/carousel")
@Api(tags = {"carousel"})
public class CarouselController extends AbstractRestHandler {

    @Autowired
    private CarouselService carouselService;

    @RequestMapping(value = "/getCarouselList",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get carousels.", notes = "You can getCarouselList.")
    public
    @ResponseBody
    List<Carousel> getCarouselList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Carousel> carousel = this.carouselService.getCarouselList();
        checkResourceFound(carousel);
        //todo: http://goo.gl/6iNAkz
        return carousel;
    }

}
