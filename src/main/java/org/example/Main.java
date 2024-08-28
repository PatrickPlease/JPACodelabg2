package org.example;

import org.example.daos.PersonDAO;
import org.example.entities.Person;

public class Main {
    public static void main(String[] args) {

        PersonDAO persondao = new PersonDAO();
        persondao.create(
                Person.builder()
                        .name("Sandra")
                        .age(29)
                        .build()
        );

    }
}