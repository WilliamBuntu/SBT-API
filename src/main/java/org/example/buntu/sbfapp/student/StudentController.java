package org.example.buntu.sbfapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    private StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.Students();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
         studentService.registerNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public  void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(
                studentService.Students()
                        .stream()
                        .filter(student -> student.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"))
        );
    }
}
