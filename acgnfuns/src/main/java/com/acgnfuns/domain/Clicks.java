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
@Table(name = "clicks")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Clicks implements Serializable {
    @Id
    @Column(name="url")
    private String url           ;
    @Column(name="count")
    private Integer count          ;
    @Column(name="type")
    private String type           ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "url")
    private AnimationBangumi animationBangumi;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "url")
    private ComicManga comicManga;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "url")
    private GameGeimu gameGeimu;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "url")
    private NovelNoberu novelNoberu;

    public Clicks() {
    }

    public Clicks(String url, Integer count, String type, AnimationBangumi animationBangumi, ComicManga comicManga, GameGeimu gameGeimu, NovelNoberu novelNoberu) {
        this.url = url;
        this.count = count;
        this.type = type;
        this.animationBangumi = animationBangumi;
        this.comicManga = comicManga;
        this.gameGeimu = gameGeimu;
        this.novelNoberu = novelNoberu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AnimationBangumi getAnimationBangumi() {
        return animationBangumi;
    }

    public void setAnimationBangumi(AnimationBangumi animationBangumi) {
        this.animationBangumi = animationBangumi;
    }

    public ComicManga getComicManga() {
        return comicManga;
    }

    public void setComicManga(ComicManga comicManga) {
        this.comicManga = comicManga;
    }

    public GameGeimu getGameGeimu() {
        return gameGeimu;
    }

    public void setGameGeimu(GameGeimu gameGeimu) {
        this.gameGeimu = gameGeimu;
    }

    public NovelNoberu getNovelNoberu() {
        return novelNoberu;
    }

    public void setNovelNoberu(NovelNoberu novelNoberu) {
        this.novelNoberu = novelNoberu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clicks)) return false;
        Clicks clicks = (Clicks) o;
        return Objects.equals(getUrl(), clicks.getUrl()) &&
                Objects.equals(getCount(), clicks.getCount()) &&
                Objects.equals(getType(), clicks.getType()) &&
                Objects.equals(getAnimationBangumi(), clicks.getAnimationBangumi()) &&
                Objects.equals(getComicManga(), clicks.getComicManga()) &&
                Objects.equals(getGameGeimu(), clicks.getGameGeimu()) &&
                Objects.equals(getNovelNoberu(), clicks.getNovelNoberu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getCount(), getType(), getAnimationBangumi(), getComicManga(), getGameGeimu(), getNovelNoberu());
    }

    @Override
    public String toString() {
        return "Clicks{" +
                "url='" + url + '\'' +
                ", count=" + count +
                ", type='" + type + '\'' +
                ", animationBangumi=" + animationBangumi +
                ", comicManga=" + comicManga +
                ", gameGeimu=" + gameGeimu +
                ", novelNoberu=" + novelNoberu +
                '}';
    }
}
