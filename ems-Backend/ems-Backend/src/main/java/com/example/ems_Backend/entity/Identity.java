package com.example.ems_Backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="identity_table")
public class Identity {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String documentType;
    private String documentNumber;
    private String additionalDetail;
    @CreationTimestamp
    private LocalDateTime createdDate;

    @ManyToOne
    private Employee employee;

    public Identity(Integer id, String documentType, String documentNumber, String additionalDetail) {
        this.id=id;
        this.documentType=documentType;
        this.documentNumber=documentNumber;
        this.additionalDetail=additionalDetail;

    }
}
