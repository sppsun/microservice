package com.acgnfuns.repository;

import com.acgnfuns.domain.GameGeimu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameGeimuRepository extends PagingAndSortingRepository<GameGeimu, String> {
    @Override
    Page<GameGeimu> findAll(Pageable pageable);

    GameGeimu findGameGeimuByUrl(String url);
}
