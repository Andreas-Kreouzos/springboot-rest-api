package com.andrekreou.springboot.controller;

import com.andrekreou.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    /**
     * Spring Boot REST API returns a Student
     * http://[::1]:8080/student
     */
    @GetMapping("student")
    public Student getStudent() {
        return new Student(
                1,
                "Andreas",
                "Kreouzos"
        );
    }

    /**
     * Spring Boot REST API returns list of Students
     * http://[::1]:8080/students
     */
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Andreas","Kreouzos"));
        students.add(new Student(2,"Anastasios","Plataras"));
        students.add(new Student(3,"Antonios","Lazos"));
        students.add(new Student(4,"Georgios Ioannis","Zacharopoulos"));

        return students;
    }

    /**
     * Spring Boot REST API with Path Variable
     * http://[::1]:8080/students/1/Andreas/Kreouzos
     */
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    /**
     * Spring Boot REST API with Request Param
     * http://[::1]:8080/students/query?id=1&firstName=Andreas&lastName=Kreouzos
     */
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }
}
