package com.acgnfuns.service;

import com.acgnfuns.repository.AnimationEpisodeRepository;
import com.acgnfuns.domain.AnimationEpisode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class AnimationEpisodeService {

    private static final Logger log = LoggerFactory.getLogger(AnimationEpisodeService.class);

    @Autowired
    private AnimationEpisodeRepository animationEpisodeRepository;

    public AnimationEpisodeService() {
    }

    public List<AnimationEpisode> getAnimationEpisodeListByBangumiUrl(String bangumiUrl) {
        return animationEpisodeRepository.findAllByBangumiUrl(bangumiUrl);
    }

    public AnimationEpisode getAnimationEpisodeByEpisodeUrl(String episodeUrl) {
        return animationEpisodeRepository.findAnimationEpisodeByEpisodeUrl(episodeUrl);
    }

}
