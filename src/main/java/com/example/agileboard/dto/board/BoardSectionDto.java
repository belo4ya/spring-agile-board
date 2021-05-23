package com.example.agileboard.dto.board;

import com.example.agileboard.dto.BaseDto;
import com.example.agileboard.models.Section;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BoardSectionDto extends BaseDto {
    private String title;
    private List<BoardSectionTaskDto> tasks;

    public BoardSectionDto(Section section) {
        super(section);
        this.title = section.getTitle();
        this.tasks = section.getTasks().stream().map(BoardSectionTaskDto::new).collect(Collectors.toList());
    }
}
