package com.acgnfuns.service;

import com.acgnfuns.repository.AnimationBangumiRepository;
import com.acgnfuns.domain.AnimationBangumi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//import org.springframework.boot.actuate.metrics.CounterService;
//import org.springframework.boot.actuate.metrics.GaugeService;

@Service
public class AnimationBangumiService {

    private static final Logger log = LoggerFactory.getLogger(AnimationBangumiService.class);

    @Autowired
    private AnimationBangumiRepository animationBangumiRepository;
    public AnimationBangumiService() {
    }

    public AnimationBangumi getAnimationBangumiByUrl(String url) {
        return animationBangumiRepository.findAnimationBangumiByUrl(url);
    }

    public Page<AnimationBangumi> getAnimationBangumiList(Integer page, Integer size) {
        return animationBangumiRepository.findAll(PageRequest.of(page, size));
    }
}
