package com.acgnfuns.repository;

import com.acgnfuns.domain.Clicks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface ClicksRepository extends PagingAndSortingRepository<Clicks, String> {
    Page<Clicks> findDistinctByTypeEqualsOrderByCountDesc(Pageable pageable, String type);
}
