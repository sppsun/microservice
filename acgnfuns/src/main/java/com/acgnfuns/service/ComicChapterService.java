package com.acgnfuns.service;

import com.acgnfuns.repository.ComicChapterRepository;
import com.acgnfuns.domain.ComicChapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class ComicChapterService {

    private static final Logger log = LoggerFactory.getLogger(ComicChapterService.class);

    @Autowired
    private ComicChapterRepository comicChapterRepository;

    public ComicChapterService() {
    }

    public List<ComicChapter> getComicChapterListByMangaUrl(String mangaUrl) {
        return comicChapterRepository.findAllByMangaUrl(mangaUrl);
    }

    public ComicChapter getComicChapterByChapterUrl(String chapterUrl) {
        return comicChapterRepository.findComicChapterByChapterUrl(chapterUrl);
    }

}
