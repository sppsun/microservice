package com.acgnfuns.repository;

import com.acgnfuns.domain.AnimationBangumi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnimationBangumiRepository extends PagingAndSortingRepository<AnimationBangumi, String> {
//    @Query(nativeQuery = true, name = "findAllAnimationBangumi")
//    List<AnimationBangumi> findAllAnimationBangumi(Pageable pageable);

    @Override
    Page<AnimationBangumi> findAll(Pageable pageable);

    AnimationBangumi findAnimationBangumiByUrl(String url);

//    @Query(nativeQuery = true, name = "findAnimationBangumiByUrl")
//    AnimationBangumi findAnimationBangumiByUrl(String url);

}
