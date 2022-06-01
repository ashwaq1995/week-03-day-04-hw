package com.demo.Ex42.w3.service;

import com.demo.Ex42.w3.exceptions.InvalidIdException;
import com.demo.Ex42.w3.model.Teacher;
import com.demo.Ex42.w3.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    public void checkTeacherIsValid(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));
    }


    public void addTeacher(Teacher teacher)  {
        teacherRepository.save(teacher);
    }

}
