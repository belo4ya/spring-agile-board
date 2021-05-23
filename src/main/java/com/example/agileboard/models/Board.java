package com.example.agileboard.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "boards")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Board extends BaseEntity {
    private String title;

    @OneToMany(mappedBy = "board")
    private List<Section> sections;
}
