package com.acgnfuns.repository;

import com.acgnfuns.domain.NovelNoberu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NovelNoberuRepository extends PagingAndSortingRepository<NovelNoberu, String> {
    @Override
    Page<NovelNoberu> findAll(Pageable pageable);

    NovelNoberu findNovelNoberuByUrl(String url);
}
