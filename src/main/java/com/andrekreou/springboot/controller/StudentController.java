package com.andrekreou.springboot.controller;

import com.andrekreou.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Spring Boot REST API that handles HTTP POST Request
     * http://[::1]:8080/students/create
     */
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    /**
     * Spring Boot REST API that handles HTTP PUT Request
     * http://[::1]:8080/students/1/create
     */
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    /**
     * Spring Boot REST API that handles HTTP DELETE Request
     * http://[::1]:8080/students/1/delete
     */
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student deleted successfully!";
    }
}
