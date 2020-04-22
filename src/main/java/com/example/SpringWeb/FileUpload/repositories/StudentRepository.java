package com.example.SpringWeb.FileUpload.repositories;

import com.example.SpringWeb.FileUpload.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
