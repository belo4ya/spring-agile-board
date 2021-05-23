package com.example.agileboard.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sections")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Section extends BaseEntity {
    private String title;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "section")
    private List<Task> tasks;
}
