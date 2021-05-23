package com.example.agileboard.repositories;

import com.example.agileboard.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findByBoardId(Long id);
}
