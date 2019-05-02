package com.acgnfuns.service;

import com.acgnfuns.repository.NovelNoberuRepository;
import com.acgnfuns.domain.NovelNoberu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//import org.springframework.boot.actuate.metrics.CounterService;
//import org.springframework.boot.actuate.metrics.GaugeService;

@Service
public class NovelNoberuService {

    private static final Logger log = LoggerFactory.getLogger(NovelNoberuService.class);

    @Autowired
    private NovelNoberuRepository novelNoberuRepository;
    public NovelNoberuService() {
    }

    public NovelNoberu getNovelNoberuByUrl(String url) {
        return novelNoberuRepository.findNovelNoberuByUrl(url);
    }

    public Page<NovelNoberu> getNovelNoberuList(Integer page, Integer size) {
        return novelNoberuRepository.findAll(PageRequest.of(page, size));
    }
}
