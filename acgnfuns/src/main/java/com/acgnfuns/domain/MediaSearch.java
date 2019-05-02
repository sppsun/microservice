package com.acgnfuns.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

@Document(indexName = "acgnfuns", type = "doc")
public class MediaSearch implements Serializable {
    @Id
    @Column(name="url")
    private String url   ;
    @Column(name="images")
    private String images  ;
    @Column(name="name")
    private String name ;
    @Column(name="area_names")
    private String areaNames  ;
    @Column(name="language")
    private String language  ;
    @Column(name="status")
    private String status   ;
    @Column(name="update_time")
    private String updateTime   ;
    @Column(name="category")
    private String category   ;

    public MediaSearch() {
    }

    public MediaSearch(String url, String images, String name, String areaNames, String language, String status, String updateTime, String category) {
        this.url = url;
        this.images = images;
        this.name = name;
        this.areaNames = areaNames;
        this.language = language;
        this.status = status;
        this.updateTime = updateTime;
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(o instanceof MediaSearch)) return false;
        MediaSearch that = (MediaSearch) o;
        return Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getImages(), that.getImages()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAreaNames(), that.getAreaNames()) &&
                Objects.equals(getLanguage(), that.getLanguage()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getUpdateTime(), that.getUpdateTime()) &&
                Objects.equals(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getImages(), getName(), getAreaNames(), getLanguage(), getStatus(), getUpdateTime(), getCategory());
    }

    @Override
    public String toString() {
        return "MediaSearch{" +
                "url='" + url + '\'' +
                ", images='" + images + '\'' +
                ", name='" + name + '\'' +
                ", areaNames='" + areaNames + '\'' +
                ", language='" + language + '\'' +
                ", status='" + status + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
