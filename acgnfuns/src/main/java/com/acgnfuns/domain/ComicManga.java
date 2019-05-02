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
@Table(name = "comic_manga")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ComicManga implements Serializable {
    @Column(name="batch_date")
    private String batchDate    ;
    @Column(name="host")
    private String host          ;
    @Id
    @Column(name="url")
    private String url           ;
    @Column(name="img")
    private String img           ;
    @Column(name="image_urls")
    private String imageUrls    ;
    @Column(name="images")
    private String images        ;
    @Column(name="name")
    private String name          ;
    @Column(name="author_names")
    private String authorNames  ;
    @Column(name="show_date")
    private String showDate     ;
    @Column(name="area_names")
    private String areaNames    ;
    @Column(name="language")
    private String language      ;
    @Column(name="status")
    private String status        ;
    @Column(name="type")
    private String type          ;
    @Column(name="introduction")
    private String introduction  ;
    @Column(name="update_time")
    private String updateTime   ;
    @Column(name="category")
    private String category      ;

    public ComicManga() {
    }

    public ComicManga(String batchDate, String host, String url, String img, String imageUrls, String images, String name, String authorNames, String showDate, String areaNames, String language, String status, String type, String introduction, String updateTime, String category) {
        this.batchDate = batchDate;
        this.host = host;
        this.url = url;
        this.img = img;
        this.imageUrls = imageUrls;
        this.images = images;
        this.name = name;
        this.authorNames = authorNames;
        this.showDate = showDate;
        this.areaNames = areaNames;
        this.language = language;
        this.status = status;
        this.type = type;
        this.introduction = introduction;
        this.updateTime = updateTime;
        this.category = category;
    }

    public String getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(String authorNames) {
        this.authorNames = authorNames;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getAreaNames() {
        return areaNames;
    }

    public void setAreaNames(String areaNames) {
        this.areaNames = areaNames;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComicManga)) return false;
        ComicManga that = (ComicManga) o;
        return Objects.equals(getBatchDate(), that.getBatchDate()) &&
                Objects.equals(getHost(), that.getHost()) &&
                Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getImg(), that.getImg()) &&
                Objects.equals(getImageUrls(), that.getImageUrls()) &&
                Objects.equals(getImages(), that.getImages()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAuthorNames(), that.getAuthorNames()) &&
                Objects.equals(getShowDate(), that.getShowDate()) &&
                Objects.equals(getAreaNames(), that.getAreaNames()) &&
                Objects.equals(getLanguage(), that.getLanguage()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getIntroduction(), that.getIntroduction()) &&
                Objects.equals(getUpdateTime(), that.getUpdateTime()) &&
                Objects.equals(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBatchDate(), getHost(), getUrl(), getImg(), getImageUrls(), getImages(), getName(), getAuthorNames(), getShowDate(), getAreaNames(), getLanguage(), getStatus(), getType(), getIntroduction(), getUpdateTime(), getCategory());
    }

    @Override
    public String toString() {
        return "AnimationBangumi{" +
                "batchDate='" + batchDate + '\'' +
                ", host='" + host + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", imageUrls='" + imageUrls + '\'' +
                ", images='" + images + '\'' +
                ", name='" + name + '\'' +
                ", authorNames='" + authorNames + '\'' +
                ", showDate='" + showDate + '\'' +
                ", areaNames='" + areaNames + '\'' +
                ", language='" + language + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", introduction='" + introduction + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
