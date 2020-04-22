package com.example.SpringWeb.FileUpload.controlers;

import com.example.SpringWeb.FileUpload.entities.StudentPhotoFile;
import com.example.SpringWeb.FileUpload.services.StudentPhotoFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/student-photo-files")
public class StudentPhotoController {

    @Autowired
    private StudentPhotoFileService studentPhotoFileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("photoFile") MultipartFile file) {
        StudentPhotoFile studentPhotoFile = studentPhotoFileService.save(file);
        return studentPhotoFile.getId();
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        StudentPhotoFile studentPhotoFile = studentPhotoFileService.findById(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(studentPhotoFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + studentPhotoFile.getFileName())
                .body(new ByteArrayResource(studentPhotoFile.getData()));
    }
}
