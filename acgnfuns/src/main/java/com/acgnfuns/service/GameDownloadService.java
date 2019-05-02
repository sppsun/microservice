package com.acgnfuns.service;

import com.acgnfuns.repository.GameDownloadRepository;
import com.acgnfuns.domain.GameDownload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class GameDownloadService {

    private static final Logger log = LoggerFactory.getLogger(GameDownloadService.class);

    @Autowired
    private GameDownloadRepository gameDownloadRepository;

    public GameDownloadService() {
    }

    public List<GameDownload> getGameDownloadListByGeimuUrl(String geimuUrl) {
        return gameDownloadRepository.findAllByGeimuUrl(geimuUrl);
    }

    public GameDownload getGameDownloadByDownloadUrl(String downloadUrl) {
        return gameDownloadRepository.findGameDownloadByDownloadUrl(downloadUrl);
    }

}
