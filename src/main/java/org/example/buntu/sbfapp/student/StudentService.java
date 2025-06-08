package org.example.buntu.sbfapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


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

    public void deleteStudent(Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }

        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"
                ));
        if (name != null && !name.isEmpty() && !Objects.equals(student.getName(),name)) {
            student.setName(name);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)) {
            boolean emailTaken = studentRepository.findStudentByEmail(email).isPresent();
            if (emailTaken) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

        studentRepository.save(student);

    }
}
