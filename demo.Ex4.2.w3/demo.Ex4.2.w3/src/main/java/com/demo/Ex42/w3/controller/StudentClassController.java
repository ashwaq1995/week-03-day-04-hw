package com.demo.Ex42.w3.controller;

import com.demo.Ex42.w3.DTO.Api;
import com.demo.Ex42.w3.model.StudentClass;
import com.demo.Ex42.w3.service.StudentClassService;
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
@RequestMapping("api/v1/studentClasses")
public class StudentClassController {

    private final StudentClassService studentClassService;

    Logger logger = LoggerFactory.getLogger(StudentClassController.class);


    @GetMapping()
    public ResponseEntity<List<StudentClass>> getStudentClass() {
        logger.info("New request coming to getStudentClass");
        List<StudentClass> studentClass = studentClassService.getStudentClass();
        return ResponseEntity.status(HttpStatus.OK).body(studentClass);
    }

    @GetMapping("/studentClasses/{id}")
    public ResponseEntity<Api> checkStudentClassIsValid(@PathVariable Integer id){
        studentClassService.checkStudentClassIsValid(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Valid StudentClass",200));
    }

    @PostMapping
    public ResponseEntity<Api> addStudentClass(@RequestBody @Valid StudentClass studentClass) {
        studentClassService.addStudentClass(studentClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("New StudentClass added!", 201));
    }

}