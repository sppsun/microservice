package com.acgnfuns.repository;

import com.acgnfuns.domain.NovelChapter;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface NovelChapterRepository extends PagingAndSortingRepository<NovelChapter, String> {
    List<NovelChapter> findAllByNoberuUrl(String noberuUrl);

    NovelChapter findNovelChapterByChapterUrl(String chapterUrl);
}
