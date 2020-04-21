package com.example.SpringWeb.FileUpload.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "student_photo_files")
public class StudentPhotoFile {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    String id;
    @Column(name = "file_name")
    String fileName;
    @Column(name = "file_type")
    String fileType;
    @Lob
    byte[] data;

    public StudentPhotoFile() {
    }

    public StudentPhotoFile(String fileName, String fileType, byte[] data) {
        this.fileName=fileName;
        this.fileType=fileType;
        this.data=data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
