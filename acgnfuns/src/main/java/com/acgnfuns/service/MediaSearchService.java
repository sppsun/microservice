package com.acgnfuns.service;

import com.acgnfuns.repository.MediaSearchRepository;
import com.acgnfuns.domain.MediaSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaSearchService {

    private static final Logger log = LoggerFactory.getLogger(MediaSearchService.class);

    @Autowired
    private MediaSearchRepository mediaSearchRepository;
    public MediaSearchService() {
    }

    public List<MediaSearch> getMediaSearchListByName(String name) {
        return mediaSearchRepository.findByName(name);
    }
}
