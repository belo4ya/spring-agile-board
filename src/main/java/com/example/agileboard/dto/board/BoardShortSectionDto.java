package com.example.agileboard.dto.board;

import com.example.agileboard.dto.BaseDto;
import com.example.agileboard.models.Section;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BoardShortSectionDto extends BaseDto {
    private String title;

    public BoardShortSectionDto(Section section) {
        super(section);
        this.title = section.getTitle();
    }
}
