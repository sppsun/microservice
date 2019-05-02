package com.acgnfuns.service;

import com.acgnfuns.repository.NovelChapterRepository;
import com.acgnfuns.domain.NovelChapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class NovelChapterService {

    private static final Logger log = LoggerFactory.getLogger(NovelChapterService.class);

    @Autowired
    private NovelChapterRepository novelChapterRepository;

    public NovelChapterService() {
    }

    public List<NovelChapter> getNovelChapterListByNoberuUrl(String noberuUrl) {
        return novelChapterRepository.findAllByNoberuUrl(noberuUrl);
    }

    public NovelChapter getNovelChapterByChapterUrl(String chapterUrl) {
        return novelChapterRepository.findNovelChapterByChapterUrl(chapterUrl);
    }

}
