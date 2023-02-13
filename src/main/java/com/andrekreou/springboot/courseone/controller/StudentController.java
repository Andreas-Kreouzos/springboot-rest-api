package com.andrekreou.springboot.courseone.bean.controller;

import com.andrekreou.springboot.courseone.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    /**
     * Spring Boot REST API returns a Student
     * http://[::1]:8080/student
     */
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Andreas",
                "Kreouzos"
        );
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "andreas").body(student);
    }

    /**
     * Spring Boot REST API returns list of Students
     * http://[::1]:8080/students
     */
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Andreas","Kreouzos"));
        students.add(new Student(2,"Anastasios","Plataras"));
        students.add(new Student(3,"Antonios","Lazos"));
        students.add(new Student(4,"Georgios Ioannis","Zacharopoulos"));

        return ResponseEntity.ok(students);
    }

    /**
     * Spring Boot REST API with Path Variable
     * http://[::1]:8080/students/1/Andreas/Kreouzos
     */
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    /**
     * Spring Boot REST API with Request Param
     * http://[::1]:8080/students/query?id=1&firstName=Andreas&lastName=Kreouzos
     */
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    /**
     * Spring Boot REST API that handles HTTP POST Request
     * http://[::1]:8080/students/create
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    /**
     * Spring Boot REST API that handles HTTP PUT Request
     * http://[::1]:8080/students/1/create
     */
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    /**
     * Spring Boot REST API that handles HTTP DELETE Request
     * http://[::1]:8080/students/1/delete
     */
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
