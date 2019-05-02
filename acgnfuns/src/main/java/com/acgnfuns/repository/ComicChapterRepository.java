package com.acgnfuns.repository;

import com.acgnfuns.domain.ComicChapter;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface ComicChapterRepository extends PagingAndSortingRepository<ComicChapter, String> {
    List<ComicChapter> findAllByMangaUrl(String mangaUrl);

    ComicChapter findComicChapterByChapterUrl(String chapterUrl);
}
