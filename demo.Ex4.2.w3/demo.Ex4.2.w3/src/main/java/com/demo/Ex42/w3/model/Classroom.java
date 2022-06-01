package com.demo.Ex42.w3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "classrooms",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<StudentClass> studentClasses;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;


}
