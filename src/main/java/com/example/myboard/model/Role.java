package com.example.myboard.model;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
