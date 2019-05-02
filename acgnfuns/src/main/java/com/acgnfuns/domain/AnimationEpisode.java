package com.acgnfuns.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "animation_episode")
@SqlResultSetMappings(
        value = {
                @SqlResultSetMapping(
                        name="findAnimationEpisodeByBangumiUrl",
                        entities=@EntityResult(
                                entityClass=AnimationEpisode.class,
                                fields={
                                        @FieldResult(name="batch_date", column="batch_date"),
                                        @FieldResult(name="bangumi_url", column="bangumi_url"),
                                        @FieldResult(name="episode_name", column="episode_name"),
                                        @FieldResult(name="episode_url", column="episode_url"),
                                        @FieldResult(name="playee_name", column="playee_name"),
                                        @FieldResult(name="playee_url", column="playee_url")
                                }
                        )
                ),
                @SqlResultSetMapping(
                        name="findAnimationEpisodeByEpisodeUrl",
                        entities=@EntityResult(
                                entityClass=AnimationEpisode.class,
                                fields={
                                        @FieldResult(name="batch_date", column="batch_date"),
                                        @FieldResult(name="bangumi_url", column="bangumi_url"),
                                        @FieldResult(name="episode_name", column="episode_name"),
                                        @FieldResult(name="episode_url", column="episode_url"),
                                        @FieldResult(name="playee_name", column="playee_name"),
                                        @FieldResult(name="playee_url", column="playee_url")
                                }
                        )
                )
        }
)
@NamedNativeQueries(
        value = {
                @NamedNativeQuery(
                        name="findAnimationEpisodeByBangumiUrl",
                        query = "SELECT DISTINCT * FROM ANIMATION_EPISODE WHERE BANGUMI_URL = ?1",
                        resultClass = AnimationEpisode.class,
                        resultSetMapping = "findAnimationEpisodeByBangumiUrl"
                ),
                @NamedNativeQuery(
                        name="findAnimationEpisodeByEpisodeUrl",
                        query = "SELECT DISTINCT * FROM ANIMATION_EPISODE WHERE EPISODE_URL = ?1",
                        resultClass = AnimationEpisode.class,
                        resultSetMapping = "findAnimationEpisodeByEpisodeUrl"
                )
        }
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AnimationEpisode  implements Serializable {
    @Column(name="batch_date")
    private String batchDate   ;
    @Column(name="bangumi_url")
    private String bangumiUrl  ;
    @Column(name="episode_name")
    private String episodeName ;
    @Id
    @Column(name="episode_url")
    private String episodeUrl  ;
    @Column(name="playee_name")
    private String playeeName  ;
    @Column(name="playee_url")
    private String playeeUrl   ;

    public AnimationEpisode() {
    }

    public AnimationEpisode(String batchDate, String bangumiUrl, String episodeName, String episodeUrl, String playeeName, String playeeUrl) {
        this.batchDate = batchDate;
        this.bangumiUrl = bangumiUrl;
        this.episodeName = episodeName;
        this.episodeUrl = episodeUrl;
        this.playeeName = playeeName;
        this.playeeUrl = playeeUrl;
    }

    public String getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public String getBangumiUrl() {
        return bangumiUrl;
    }

    public void setBangumiUrl(String bangumiUrl) {
        this.bangumiUrl = bangumiUrl;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getEpisodeUrl() {
        return episodeUrl;
    }

    public void setEpisodeUrl(String episodeUrl) {
        this.episodeUrl = episodeUrl;
    }

    public String getPlayeeName() {
        return playeeName;
    }

    public void setPlayeeName(String playeeName) {
        this.playeeName = playeeName;
    }

    public String getPlayeeUrl() {
        return playeeUrl;
    }

    public void setPlayeeUrl(String playeeUrl) {
        this.playeeUrl = playeeUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnimationEpisode)) return false;
        AnimationEpisode that = (AnimationEpisode) o;
        return Objects.equals(getBatchDate(), that.getBatchDate()) &&
                Objects.equals(getBangumiUrl(), that.getBangumiUrl()) &&
                Objects.equals(getEpisodeName(), that.getEpisodeName()) &&
                Objects.equals(getEpisodeUrl(), that.getEpisodeUrl()) &&
                Objects.equals(getPlayeeName(), that.getPlayeeName()) &&
                Objects.equals(getPlayeeUrl(), that.getPlayeeUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBatchDate(), getBangumiUrl(), getEpisodeName(), getEpisodeUrl(), getPlayeeName(), getPlayeeUrl());
    }

    @Override
    public String toString() {
        return "AnimationEpisode{" +
                "batchDate='" + batchDate + '\'' +
                ", bangumiUrl='" + bangumiUrl + '\'' +
                ", episodeName='" + episodeName + '\'' +
                ", episodeUrl='" + episodeUrl + '\'' +
                ", playeeName='" + playeeName + '\'' +
                ", playeeUrl='" + playeeUrl + '\'' +
                '}';
    }
}
