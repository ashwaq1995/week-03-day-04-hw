package com.demo.Ex42.w3.controller;

import com.demo.Ex42.w3.DTO.Api;
import com.demo.Ex42.w3.model.Teacher;

import com.demo.Ex42.w3.service.TeacherService;

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
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    Logger logger = LoggerFactory.getLogger(TeacherController.class);


    @GetMapping()
    public ResponseEntity<List<Teacher>> getTeacher() {
        logger.info("New request coming to getTeacher");
        List<Teacher> studentClass = teacherService.getTeacher();
        return ResponseEntity.status(HttpStatus.OK).body(studentClass);
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Api> checkTeacherIsValid(@PathVariable Integer id){
        teacherService.checkTeacherIsValid(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Valid Teacher",200));
    }

    @PostMapping
    public ResponseEntity<Api> addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("New Teacher added!", 201));
    }
}