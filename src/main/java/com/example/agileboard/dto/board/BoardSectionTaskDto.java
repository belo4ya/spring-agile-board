package com.example.agileboard.dto.board;

import com.example.agileboard.dto.BaseDto;
import com.example.agileboard.models.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BoardSectionTaskDto extends BaseDto {
    private String title;
    private String description;
    private Long user;

    public BoardSectionTaskDto(Task task) {
        super(task);
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.user = task.getUser().getId();
    }
}
