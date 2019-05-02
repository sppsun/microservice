package com.acgnfuns.service;

import com.acgnfuns.repository.ComicMangaRepository;
import com.acgnfuns.domain.ComicManga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//import org.springframework.boot.actuate.metrics.CounterService;
//import org.springframework.boot.actuate.metrics.GaugeService;

@Service
public class ComicMangaService {

    private static final Logger log = LoggerFactory.getLogger(ComicMangaService.class);

    @Autowired
    private ComicMangaRepository comicMangaRepository;
    public ComicMangaService() {
    }

    public ComicManga getComicMangaByUrl(String url) {
        return comicMangaRepository.findComicMangaByUrl(url);
    }

    public Page<ComicManga> getComicMangaList(Integer page, Integer size) {
        return comicMangaRepository.findAll(PageRequest.of(page, size));
    }
}
