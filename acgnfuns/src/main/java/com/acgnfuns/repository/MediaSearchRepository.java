package com.acgnfuns.repository;

import com.acgnfuns.domain.MediaSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface MediaSearchRepository extends ElasticsearchRepository<MediaSearch, String> {
    List<MediaSearch> findByName(String name);
}