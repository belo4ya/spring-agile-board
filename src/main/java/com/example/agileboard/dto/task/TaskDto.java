package com.example.agileboard.dto.task;

import com.example.agileboard.dto.BaseDto;
import com.example.agileboard.models.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class TaskDto extends BaseDto {
    private String title;
    private String description;
    private Long user;
    private TaskSectionDto section;

    public TaskDto(Task task) {
        super(task);
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.user = task.getUser().getId();
        this.section = new TaskSectionDto(task.getSection());
    }
}
