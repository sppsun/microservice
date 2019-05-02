package com.acgnfuns.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "person")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Integer id;
    @Column()
    private String name;
    @Column()
    private Integer age;
    @Column(insertable = false, updatable = false)
    private String descRefId;
    @Column(insertable = false, updatable = false)
    private String avatarRefId;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name="descRefId", referencedColumnName = "docId", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private DocumentText desc;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name="avatarRefId", referencedColumnName = "docId", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private DocumentBinary ava;

    public Person() {
    }

    public Person(String name, Integer age, String descRefId, String avatarRefId, DocumentText desc, DocumentBinary ava) {
        this.name = name;
        this.age = age;
        this.descRefId = descRefId;
        this.avatarRefId = avatarRefId;
        this.desc = desc;
        this.ava = ava;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescRefId() {
        return descRefId;
    }

    public void setDescRefId(String descRefId) {
        this.descRefId = descRefId;
    }

    public String getAvatarRefId() {
        return avatarRefId;
    }

    public void setAvatarRefId(String avatarRefId) {
        this.avatarRefId = avatarRefId;
    }

    public DocumentText getDesc() {
        return desc;
    }

    public void setDesc(DocumentText desc) {
        this.desc = desc;
    }

    public DocumentBinary getAva() {
        return ava;
    }

    public void setAva(DocumentBinary ava) {
        this.ava = ava;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getAge(), person.getAge()) &&
                Objects.equals(getDescRefId(), person.getDescRefId()) &&
                Objects.equals(getAvatarRefId(), person.getAvatarRefId()) &&
                Objects.equals(getDesc(), person.getDesc()) &&
                Objects.equals(getAva(), person.getAva());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getDescRefId(), getAvatarRefId(), getDesc(), getAva());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", descRefId='" + descRefId + '\'' +
                ", avatarRefId='" + avatarRefId + '\'' +
                ", desc=" + desc +
                ", ava=" + ava +
                '}';
    }
}
