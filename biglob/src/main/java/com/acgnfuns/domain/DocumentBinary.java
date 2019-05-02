package com.acgnfuns.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "document_binary")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentBinary implements Serializable {
    @Id
    @Column()
    private String docId;
    @Column()
    private String docName;
    @Column()
    private String docType;
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition="BINARY")
    private byte[] docBinary;

    public DocumentBinary() {
    }

    public DocumentBinary(String docId, String docName, String docType, byte[] docBinary) {
        this.docId = docId;
        this.docName = docName;
        this.docType = docType;
        this.docBinary = docBinary;
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

    public byte[] getDocBinary() {
        return docBinary;
    }

    public void setDocBinary(byte[] docBinary) {
        this.docBinary = docBinary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentBinary)) return false;
        DocumentBinary that = (DocumentBinary) o;
        return Objects.equals(getDocId(), that.getDocId()) &&
                Objects.equals(getDocName(), that.getDocName()) &&
                Objects.equals(getDocType(), that.getDocType()) &&
                Arrays.equals(getDocBinary(), that.getDocBinary());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getDocId(), getDocName(), getDocType());
        result = 31 * result + Arrays.hashCode(getDocBinary());
        return result;
    }

    @Override
    public String toString() {
        return "DocumentBinary{" +
                "docId='" + docId + '\'' +
                ", docName='" + docName + '\'' +
                ", docType='" + docType + '\'' +
                ", docBinary=" + Arrays.toString(docBinary) +
                '}';
    }
}
