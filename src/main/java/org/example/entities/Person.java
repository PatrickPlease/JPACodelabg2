package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "jpademo")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generates the id
    private Integer id;
    private String name;
    private Integer age;
}
