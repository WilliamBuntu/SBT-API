package org.example.buntu.sbfapp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class Studentconfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student student1 = new Student(
                    "James bond",
                    "james@gmail.com",
                    LocalDate.of(2002, 12, 5));

            Student student2 = new Student(
                    "Maria Jones",
                    "mariam@gmail.com",
                    LocalDate.of(2007, 1, 5));

            studentRepository.saveAll(
                    List.of(student1, student2)
            );
        };

       
    }

}
