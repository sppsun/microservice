package com.acgnfuns.repository;

import com.acgnfuns.domain.AnimationEpisode;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface AnimationEpisodeRepository extends PagingAndSortingRepository<AnimationEpisode, String> {
//    @Query(nativeQuery = true, name="findAnimationEpisodeByBangumiUrl")
//    List<AnimationEpisode> findAnimationEpisodeByBangumiUrl(String bangumiUrl);

    List<AnimationEpisode> findAllByBangumiUrl(String bangumiUrl);

//    @Query(nativeQuery = true, name="findAnimationEpisodeByEpisodeUrl")
//    AnimationEpisode findAnimationEpisodeByEpisodeUrl(String episodeUrl);

    AnimationEpisode findAnimationEpisodeByEpisodeUrl(String episodeUrl);

}
