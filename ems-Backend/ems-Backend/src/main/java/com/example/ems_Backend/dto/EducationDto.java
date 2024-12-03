package com.example.ems_Backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EducationDto {

    private Integer id;
    private Integer year;
    private String degree;
    private String institute;


}
