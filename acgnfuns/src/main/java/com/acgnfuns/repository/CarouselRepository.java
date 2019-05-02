package com.acgnfuns.repository;

import com.acgnfuns.domain.Carousel;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface CarouselRepository extends PagingAndSortingRepository<Carousel, String> {
    List<Carousel> findAll();
}
