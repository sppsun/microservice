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
@Table(name = "game_download")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GameDownload implements Serializable {
    @Column(name="batch_date")
    private String batchDate   ;
    @Column(name="geimu_url")
    private String geimuUrl  ;
    @Column(name="download_name")
    private String downloadName ;
    @Id
    @Column(name="download_url")
    private String downloadUrl  ;

    public GameDownload() {
    }

    public GameDownload(String batchDate, String geimuUrl, String downloadName, String downloadUrl) {
        this.batchDate = batchDate;
        this.geimuUrl = geimuUrl;
        this.downloadName = downloadName;
        this.downloadUrl = downloadUrl;
    }

    public String getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public String getGeimuUrl() {
        return geimuUrl;
    }

    public void setGeimuUrl(String geimuUrl) {
        this.geimuUrl = geimuUrl;
    }

    public String getDownloadName() {
        return downloadName;
    }

    public void setDownloadName(String downloadName) {
        this.downloadName = downloadName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameDownload)) return false;
        GameDownload that = (GameDownload) o;
        return Objects.equals(getBatchDate(), that.getBatchDate()) &&
                Objects.equals(getGeimuUrl(), that.getGeimuUrl()) &&
                Objects.equals(getDownloadName(), that.getDownloadName()) &&
                Objects.equals(getDownloadUrl(), that.getDownloadUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBatchDate(), getGeimuUrl(), getDownloadName(), getDownloadUrl());
    }

    @Override
    public String toString() {
        return "GameDownload{" +
                "batchDate='" + batchDate + '\'' +
                ", geimuUrl='" + geimuUrl + '\'' +
                ", downloadName='" + downloadName + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}
