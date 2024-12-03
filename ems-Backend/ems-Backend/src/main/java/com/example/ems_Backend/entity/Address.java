package com.example.ems_Backend.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Address_table")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;

    private String pinCode;
    private String addressType;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;



    @ManyToOne
    private Employee employee;






    public Address(String addressLine1, String addressLine2, String addressLine3, String city, String state, String pinCode, String addressType) {
    this.addressLine1=addressLine1;
    this.addressLine2=addressLine2;
    this.city=city;
    this.state=state;
    this.pinCode=pinCode;
    this.addressType=addressType;





    }
}

