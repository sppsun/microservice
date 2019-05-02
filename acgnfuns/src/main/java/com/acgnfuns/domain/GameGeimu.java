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
@Table(name = "game_geimu")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GameGeimu implements Serializable {
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
    @Column(name="zh_name")
    private String zhName  ;
    @Column(name="en_name")
    private String enName   ;
    @Column(name="creator_names")
    private String creatorNames;
    @Column(name="publisher_names")
    private String publisherNames;
    @Column(name="area_names")
    private String areaNames    ;
    @Column(name="language")
    private String language      ;
    @Column(name="type")
    private String type          ;
    @Column(name="update_time")
    private String updateTime   ;
    @Column(name="publish_date")
    private String publishDate     ;
    @Column(name="show_date")
    private String showDate     ;
    @Column(name="size")
    private String size        ;
    @Column(name="status")
    private String status        ;
    @Column(name="introduction")
    private String introduction  ;
    @Column(name="category")
    private String category      ;

    public GameGeimu() {
    }

    public GameGeimu(String batchDate, String host, String url, String img, String imageUrls, String images, String name, String zhName, String enName, String creatorNames, String publisherNames, String areaNames, String language, String type, String updateTime, String publishDate, String showDate, String size, String status, String introduction, String category) {
        this.batchDate = batchDate;
        this.host = host;
        this.url = url;
        this.img = img;
        this.imageUrls = imageUrls;
        this.images = images;
        this.name = name;
        this.zhName = zhName;
        this.enName = enName;
        this.creatorNames = creatorNames;
        this.publisherNames = publisherNames;
        this.areaNames = areaNames;
        this.language = language;
        this.type = type;
        this.updateTime = updateTime;
        this.publishDate = publishDate;
        this.showDate = showDate;
        this.size = size;
        this.status = status;
        this.introduction = introduction;
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

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCreatorNames() {
        return creatorNames;
    }

    public void setCreatorNames(String creatorNames) {
        this.creatorNames = creatorNames;
    }

    public String getPublisherNames() {
        return publisherNames;
    }

    public void setPublisherNames(String publisherNames) {
        this.publisherNames = publisherNames;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
        if (!(o instanceof GameGeimu)) return false;
        GameGeimu gameGeimu = (GameGeimu) o;
        return Objects.equals(getBatchDate(), gameGeimu.getBatchDate()) &&
                Objects.equals(getHost(), gameGeimu.getHost()) &&
                Objects.equals(getUrl(), gameGeimu.getUrl()) &&
                Objects.equals(getImg(), gameGeimu.getImg()) &&
                Objects.equals(getImageUrls(), gameGeimu.getImageUrls()) &&
                Objects.equals(getImages(), gameGeimu.getImages()) &&
                Objects.equals(getName(), gameGeimu.getName()) &&
                Objects.equals(getZhName(), gameGeimu.getZhName()) &&
                Objects.equals(getEnName(), gameGeimu.getEnName()) &&
                Objects.equals(getCreatorNames(), gameGeimu.getCreatorNames()) &&
                Objects.equals(getPublisherNames(), gameGeimu.getPublisherNames()) &&
                Objects.equals(getAreaNames(), gameGeimu.getAreaNames()) &&
                Objects.equals(getLanguage(), gameGeimu.getLanguage()) &&
                Objects.equals(getType(), gameGeimu.getType()) &&
                Objects.equals(getUpdateTime(), gameGeimu.getUpdateTime()) &&
                Objects.equals(getPublishDate(), gameGeimu.getPublishDate()) &&
                Objects.equals(getShowDate(), gameGeimu.getShowDate()) &&
                Objects.equals(getSize(), gameGeimu.getSize()) &&
                Objects.equals(getStatus(), gameGeimu.getStatus()) &&
                Objects.equals(getIntroduction(), gameGeimu.getIntroduction()) &&
                Objects.equals(getCategory(), gameGeimu.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBatchDate(), getHost(), getUrl(), getImg(), getImageUrls(), getImages(), getName(), getZhName(), getEnName(), getCreatorNames(), getPublisherNames(), getAreaNames(), getLanguage(), getType(), getUpdateTime(), getPublishDate(), getShowDate(), getSize(), getStatus(), getIntroduction(), getCategory());
    }

    @Override
    public String toString() {
        return "GameGeimu{" +
                "batchDate='" + batchDate + '\'' +
                ", host='" + host + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", imageUrls='" + imageUrls + '\'' +
                ", images='" + images + '\'' +
                ", name='" + name + '\'' +
                ", zhName='" + zhName + '\'' +
                ", enName='" + enName + '\'' +
                ", creatorNames='" + creatorNames + '\'' +
                ", publisherNames='" + publisherNames + '\'' +
                ", areaNames='" + areaNames + '\'' +
                ", language='" + language + '\'' +
                ", type='" + type + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", showDate='" + showDate + '\'' +
                ", size='" + size + '\'' +
                ", status='" + status + '\'' +
                ", introduction='" + introduction + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
