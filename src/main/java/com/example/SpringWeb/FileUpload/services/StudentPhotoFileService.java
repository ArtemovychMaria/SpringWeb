package com.example.SpringWeb.FileUpload.services;

import com.example.SpringWeb.FileUpload.entities.StudentPhotoFile;
import com.example.SpringWeb.FileUpload.repositories.StudentPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StudentPhotoFileService {

    private StudentPhotoRepository studentPhotoRepository;

    @Autowired
    public StudentPhotoFileService(StudentPhotoRepository studentPhotoRepository){
        this.studentPhotoRepository=studentPhotoRepository;
    }

    public StudentPhotoFile save(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            StudentPhotoFile studentPhotoFile = new StudentPhotoFile(fileName, file.getContentType(), file.getBytes());
            return studentPhotoRepository.save(studentPhotoFile);
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName, ex);
        }
    }

    public StudentPhotoFile findById(String fileId) {
        return studentPhotoRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));
    }



}
