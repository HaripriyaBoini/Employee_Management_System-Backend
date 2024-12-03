package com.example.ems_Backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="emp_Education")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Education {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer year;
    private String degree;
    private String institute;

    public Education(Integer id,Integer year,String degree,String institute) {
       this.id=id;
       this.year=year;
       this.degree=degree;
       this.institute=institute;



        this.degree = degree;
    }

    @ManyToOne
    @JoinColumn(name="employee_id")
        private Employee employee;

}
