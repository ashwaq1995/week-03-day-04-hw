package com.demo.Ex42.w3.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;

}
