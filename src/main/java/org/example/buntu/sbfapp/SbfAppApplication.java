package org.example.buntu.sbfapp;

import org.example.buntu.sbfapp.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SbfAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbfAppApplication.class, args);
    }

}
