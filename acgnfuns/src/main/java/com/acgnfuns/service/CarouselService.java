package com.acgnfuns.service;

import com.acgnfuns.repository.CarouselRepository;
import com.acgnfuns.domain.Carousel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class CarouselService {

    private static final Logger log = LoggerFactory.getLogger(CarouselService.class);

    @Autowired
    private CarouselRepository carouselRepository;

    public CarouselService() {
    }

    public List<Carousel> getCarouselList() {
        return carouselRepository.findAll();
    }

}
