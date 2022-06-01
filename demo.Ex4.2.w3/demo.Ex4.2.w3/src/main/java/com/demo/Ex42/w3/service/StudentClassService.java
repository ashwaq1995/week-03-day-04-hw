package com.demo.Ex42.w3.service;

import com.demo.Ex42.w3.exceptions.InvalidIdException;
import com.demo.Ex42.w3.model.StudentClass;
import com.demo.Ex42.w3.repository.StudentClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentClassService {

    private final StudentClassRepository studentClassRepository;


    public List<StudentClass> getStudentClass() {
        return studentClassRepository.findAll();
    }

    public void checkStudentClassIsValid(Integer id) {
        StudentClass studentClass = studentClassRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));
    }


    public void addStudentClass(StudentClass studentClass)  {
        studentClassRepository.save(studentClass);
    }

}
