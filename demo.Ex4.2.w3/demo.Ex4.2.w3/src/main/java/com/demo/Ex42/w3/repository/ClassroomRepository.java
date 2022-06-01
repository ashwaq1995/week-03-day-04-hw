package com.demo.Ex42.w3.repository;

import com.demo.Ex42.w3.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
}
