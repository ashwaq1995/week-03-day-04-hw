package com.demo.Ex42.w3.controller;

import com.demo.Ex42.w3.DTO.Api;
import com.demo.Ex42.w3.model.Classroom;
import com.demo.Ex42.w3.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    Logger logger = LoggerFactory.getLogger(ClassroomController.class);

    @GetMapping()
    public ResponseEntity<List<Classroom>> getClassroom() {
        logger.info("New request coming to getClassroom");
        List<Classroom> classrooms = classroomService.getClassroom();
        return ResponseEntity.status(HttpStatus.OK).body(classrooms);
    }

    @GetMapping("/classroom/{id}")
    public ResponseEntity<Api> checkClassroomIsValid(@PathVariable Integer id){
        classroomService.checkClassroomIsValid(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Valid user",200));
    }

    @PostMapping
    public ResponseEntity<Api> addClassroom(@RequestBody @Valid  Classroom classroom) {
        classroomService.addClassroom(classroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("New classroom added!", 201));
    }

}