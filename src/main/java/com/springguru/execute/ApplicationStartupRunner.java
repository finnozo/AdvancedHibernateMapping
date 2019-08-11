package com.springguru.execute;

import com.springguru.entity.Student;
import com.springguru.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public ApplicationStartupRunner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createStudent();
    }

    private void createStudent() {
        Student student = new Student("Sandeep","Dangi","dangi.sushil5@gmail.com");
        Set<String> images = student.getImages();
        images.add("image1.jpg");
        images.add("image2.jpg");
        images.add("image3.jpg");
        images.add("image4.jpg");
        images.add("image4.jpg");


        studentRepository.save(student);
    }
}