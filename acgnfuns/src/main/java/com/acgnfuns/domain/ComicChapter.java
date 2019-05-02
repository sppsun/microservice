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
@Table(name = "comic_chapter")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ComicChapter implements Serializable {
    @Column(name="batch_date")
    private String batchDate   ;
    @Column(name="manga_url")
    private String mangaUrl  ;
    @Column(name="chapter_name")
    private String chapterName ;
    @Id
    @Column(name="chapter_url")
    private String chapterUrl  ;

    public ComicChapter() {
    }

    public ComicChapter(String batchDate, String mangaUrl, String chapterName, String chapterUrl) {
        this.batchDate = batchDate;
        this.mangaUrl = mangaUrl;
        this.chapterName = chapterName;
        this.chapterUrl = chapterUrl;
    }

    public String getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public String getMangaUrl() {
        return mangaUrl;
    }

    public void setMangaUrl(String mangaUrl) {
        this.mangaUrl = mangaUrl;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterUrl() {
        return chapterUrl;
    }

    public void setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComicChapter)) return false;
        ComicChapter that = (ComicChapter) o;
        return Objects.equals(getBatchDate(), that.getBatchDate()) &&
                Objects.equals(getMangaUrl(), that.getMangaUrl()) &&
                Objects.equals(getChapterName(), that.getChapterName()) &&
                Objects.equals(getChapterUrl(), that.getChapterUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBatchDate(), getMangaUrl(), getChapterName(), getChapterUrl());
    }

    @Override
    public String toString() {
        return "ComicChapter{" +
                "batchDate='" + batchDate + '\'' +
                ", mangaUrl='" + mangaUrl + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", chapterUrl='" + chapterUrl + '\'' +
                '}';
    }
}
