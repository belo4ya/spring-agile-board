package com.example.agileboard.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class User extends BaseEntity {
    @Column(unique = true)
    private String name;

    private String avatar;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}
