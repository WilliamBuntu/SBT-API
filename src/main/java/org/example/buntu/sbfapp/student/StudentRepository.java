package org.example.buntu.sbfapp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    java.util.Optional<Student> findStudentByEmail(String email);
    // This method is used to find a student by their email address.
}
