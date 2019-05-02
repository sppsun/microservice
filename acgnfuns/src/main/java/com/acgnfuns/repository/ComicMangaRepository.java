package com.acgnfuns.repository;

import com.acgnfuns.domain.ComicManga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ComicMangaRepository extends PagingAndSortingRepository<ComicManga, String> {
    @Override
    Page<ComicManga> findAll(Pageable pageable);

    ComicManga findComicMangaByUrl(String url);
}
