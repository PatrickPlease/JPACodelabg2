package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "jpademo")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generates the id
    private Integer id;
    private String name;
    private Integer age;
    private Integer phonenumber;
    private String email;
    private String address;
    private LocalDate birthdate;
    private LocalDate dateofenrollment;
}
