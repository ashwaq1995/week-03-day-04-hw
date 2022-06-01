package com.demo.Ex42.w3.service;

import com.demo.Ex42.w3.exceptions.InvalidIdException;
import com.demo.Ex42.w3.model.Classroom;
import com.demo.Ex42.w3.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;


    public List<Classroom> getClassroom() {
        return classroomRepository.findAll();
    }

    public void checkClassroom(Integer id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));
    }


    public void addClassroom(Classroom classroom)  {
        classroomRepository.save(classroom);
    }

    public void checkClassroomIsValid(Integer id) {
    }
}
