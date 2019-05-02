package com.acgnfuns.service;

import com.acgnfuns.repository.GameGeimuRepository;
import com.acgnfuns.domain.GameGeimu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//import org.springframework.boot.actuate.metrics.CounterService;
//import org.springframework.boot.actuate.metrics.GaugeService;

@Service
public class GameGeimuService {

    private static final Logger log = LoggerFactory.getLogger(GameGeimuService.class);

    @Autowired
    private GameGeimuRepository gameGeimuRepository;
    public GameGeimuService() {
    }

    public GameGeimu getGameGeimuByUrl(String url) {
        return gameGeimuRepository.findGameGeimuByUrl(url);
    }

    public Page<GameGeimu> getGameGeimuList(Integer page, Integer size) {
        return gameGeimuRepository.findAll(PageRequest.of(page, size));
    }
}
