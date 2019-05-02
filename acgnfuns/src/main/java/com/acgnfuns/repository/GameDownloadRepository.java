package com.acgnfuns.repository;

import com.acgnfuns.domain.GameDownload;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface GameDownloadRepository extends PagingAndSortingRepository<GameDownload, String> {
    List<GameDownload> findAllByGeimuUrl(String geimuUrl);

    GameDownload findGameDownloadByDownloadUrl(String downloadUrl);
}
