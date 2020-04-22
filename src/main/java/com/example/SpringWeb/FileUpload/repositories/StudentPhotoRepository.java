package com.example.SpringWeb.FileUpload.repositories;

import com.example.SpringWeb.FileUpload.entities.StudentPhotoFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPhotoRepository extends CrudRepository<StudentPhotoFile,String> {
}
