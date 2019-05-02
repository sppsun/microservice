package com.acgnfuns.service;

import com.acgnfuns.repository.ClicksRepository;
import com.acgnfuns.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.springframework.boot.actuate.metrics.CounterService;
//import org.springframework.boot.actuate.metrics.GaugeService;

@Service
public class ClicksService {

    private static final Logger log = LoggerFactory.getLogger(ClicksService.class);

    @Autowired
    private ClicksRepository clicksRepository;

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public ClicksService() {
    }

    public Page<Clicks> getClicksList(Integer page, Integer size, String type) {
        return clicksRepository.findDistinctByTypeEqualsOrderByCountDesc(PageRequest.of(page, size), type);
    }

    @Transactional
    public Clicks save(String url, String type)
    {
        AnimationBangumi animationBangumi = null;
        ComicManga comicManga = null;
        GameGeimu gameGeimu = null;
        NovelNoberu novelNoberu = null;
        if ("动画".equals(type))
            animationBangumi = entityManager.find(AnimationBangumi.class, url);
        else
        if ("漫画".equals(type))
            comicManga = entityManager.find(ComicManga.class, url);
        else
        if ("游戏".equals(type))
            gameGeimu = entityManager.find(GameGeimu.class, url);
        else
        if ("轻小说".equals(type))
            novelNoberu = entityManager.find(NovelNoberu.class, url);
        if (animationBangumi == null && comicManga == null && gameGeimu == null && novelNoberu == null)
            return null;
        Clicks clicks = new Clicks();
        clicks.setUrl(url);
        clicks.setType(type);
        Clicks manageredClicks = entityManager.find(Clicks.class, url);
        if (manageredClicks != null)
            clicks.setCount(manageredClicks.getCount() + 1);
        else
            clicks.setCount(1);
        return clicksRepository.save(clicks);
    }
}
