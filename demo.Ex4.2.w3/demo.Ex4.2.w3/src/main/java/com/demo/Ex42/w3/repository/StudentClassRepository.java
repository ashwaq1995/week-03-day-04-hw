package com.demo.Ex42.w3.repository;

import com.demo.Ex42.w3.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass,Integer> {
}
