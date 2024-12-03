package com.example.ems_Backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    public Employee(Long id, String firstName, String lastName, String email) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    @OneToMany(mappedBy="employee")
    private List<Education> education;


    }




