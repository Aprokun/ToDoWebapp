package ru.mashurov.todowebapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Task> tasks;
}
