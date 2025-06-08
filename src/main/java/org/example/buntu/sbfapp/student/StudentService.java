package org.example.buntu.sbfapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> Students() {
        return studentRepository.findAll();
    }

    public void registerNewStudent(Student student) {
        boolean studentExists = studentRepository
                .findStudentByEmail(student.getEmail())
                .isPresent();
        if (studentExists) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }
}
