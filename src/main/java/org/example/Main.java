package org.example;

import org.example.daos.PersonDAO;
import org.example.daos.StudentDAO;
import org.example.entities.Person;
import org.example.entities.Student;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

       StudentDAO studentDAO = new StudentDAO();

       //Create new student
       /* LocalDate bd =LocalDate.of(2024,8,23);

        studentdao.create(
                Student.builder()
                        .name("Sandra")
                        .age(29)
                        .phonenumber(72635475)
                        .email("sandra@hej.dk")
                        .address("hejvej 32 1.th")
                        .birthdate(bd)
                        .dateofenrollment(LocalDate.now())
                        .build()
        );
        */

        //Update student info

       /* Student student2 = studentDAO.getById(2);

        student2.setEmail("sadygirl@hello.dk");
        studentDAO.update(student2);*/

        //Delete student

       /* Student student1 = studentDAO.getById(1);
        studentDAO.delete(student1);
        */
        //List all students

        studentDAO.getAll().forEach(System.out::println);

        //List all courses for a specific student


    }
}