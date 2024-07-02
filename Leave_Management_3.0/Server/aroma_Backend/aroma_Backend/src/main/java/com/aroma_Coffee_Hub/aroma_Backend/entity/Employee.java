package com.aroma_Coffee_Hub.aroma_Backend.entity;

import ch.qos.logback.core.model.NamedModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lms_manage")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private  String firstname;
    @Column(name = "lastname")
    private  String lastname;
    @Column(name = "gender")
    private String gender;
    @Column(name = "role")
    private String role;
}
