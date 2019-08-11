package com.springguru.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @CollectionTable(
            name = "image",
            joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "file_name")
    private Set<String> images = new HashSet<>();

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
