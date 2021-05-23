package com.example.agileboard.dto.task;

import com.example.agileboard.dto.BaseDto;
import com.example.agileboard.models.Section;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class TaskSectionDto extends BaseDto {
    private String title;

    public TaskSectionDto(Section section) {
        super(section);
        this.title = section.getTitle();
    }
}
