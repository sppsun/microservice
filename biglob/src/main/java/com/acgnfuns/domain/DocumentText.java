package com.acgnfuns.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "document_text")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentText implements Serializable {
    @Id
    @Column()
    private String docId;
    @Column()
    private String docName;
    @Column()
    private String docType;
    @Column()
    @Lob @Basic(fetch = FetchType.LAZY)
    private String docText;

    public DocumentText() {
    }

    public DocumentText(String docId, String docName, String docType, String docText) {
        this.docId = docId;
        this.docName = docName;
        this.docType = docType;
        this.docText = docText;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocText() {
        return docText;
    }

    public void setDocText(String docText) {
        this.docText = docText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentText)) return false;
        DocumentText that = (DocumentText) o;
        return Objects.equals(getDocId(), that.getDocId()) &&
                Objects.equals(getDocName(), that.getDocName()) &&
                Objects.equals(getDocType(), that.getDocType()) &&
                Objects.equals(getDocText(), that.getDocText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocId(), getDocName(), getDocType(), getDocText());
    }

    @Override
    public String toString() {
        return "DocumentText{" +
                "docId='" + docId + '\'' +
                ", docName='" + docName + '\'' +
                ", docType='" + docType + '\'' +
                ", docText='" + docText + '\'' +
                '}';
    }
}
