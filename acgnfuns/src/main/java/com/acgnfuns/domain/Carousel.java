package com.acgnfuns.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "carousel")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Carousel implements Serializable {
    @Column(name="name")
    private String name          ;
    @Id
    @Column(name="img")
    private String img           ;
    @Column(name="url")
    private String url           ;
    @Column(name="desc")
    private String desc  ;
    @Column(name="order")
    private Integer order          ;
    @Column(name="enabled")
    private Boolean enabled          ;
    @Column(name="update_time")
    private Timestamp updateTime   ;

    public Carousel() {
    }

    public Carousel(String name, String img, String url, String desc, Integer order, Boolean enabled, Timestamp updateTime) {
        this.name = name;
        this.img = img;
        this.url = url;
        this.desc = desc;
        this.order = order;
        this.enabled = enabled;
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carousel)) return false;
        Carousel carousel = (Carousel) o;
        return Objects.equals(getName(), carousel.getName()) &&
                Objects.equals(getImg(), carousel.getImg()) &&
                Objects.equals(getUrl(), carousel.getUrl()) &&
                Objects.equals(getDesc(), carousel.getDesc()) &&
                Objects.equals(getOrder(), carousel.getOrder()) &&
                Objects.equals(getEnabled(), carousel.getEnabled()) &&
                Objects.equals(getUpdateTime(), carousel.getUpdateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getImg(), getUrl(), getDesc(), getOrder(), getEnabled(), getUpdateTime());
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                ", order=" + order +
                ", enabled=" + enabled +
                ", updateTime=" + updateTime +
                '}';
    }
}
