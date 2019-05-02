package com.acgnfuns.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "novel_chapter")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NovelChapter implements Serializable {
    @Column(name="batch_date")
    private String batchDate   ;
    @Column(name="noberu_url")
    private String noberuUrl  ;
    @Column(name="chapter_name")
    private String chapterName ;
    @Id
    @Column(name="chapter_url")
    private String chapterUrl  ;

    public NovelChapter() {
    }

    public NovelChapter(String batchDate, String noberuUrl, String chapterName, String chapterUrl) {
        this.batchDate = batchDate;
        this.noberuUrl = noberuUrl;
        this.chapterName = chapterName;
        this.chapterUrl = chapterUrl;
    }

    public String getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public String getNoberuUrl() {
        return noberuUrl;
    }

    public void setNoberuUrl(String noberuUrl) {
        this.noberuUrl = noberuUrl;
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
        if (!(o instanceof NovelChapter)) return false;
        NovelChapter that = (NovelChapter) o;
        return Objects.equals(getBatchDate(), that.getBatchDate()) &&
                Objects.equals(getNoberuUrl(), that.getNoberuUrl()) &&
                Objects.equals(getChapterName(), that.getChapterName()) &&
                Objects.equals(getChapterUrl(), that.getChapterUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBatchDate(), getNoberuUrl(), getChapterName(), getChapterUrl());
    }

    @Override
    public String toString() {
        return "NovelChapter{" +
                "batchDate='" + batchDate + '\'' +
                ", noberuUrl='" + noberuUrl + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", chapterUrl='" + chapterUrl + '\'' +
                '}';
    }
}
