package com.example.agileboard.dto.board;

import com.example.agileboard.dto.BaseDto;
import com.example.agileboard.models.Board;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BoardDto extends BaseDto {
    private String title;
    private List<BoardShortSectionDto> sections;

    public BoardDto(Board board) {
        super(board);
        this.title = board.getTitle();
        this.sections = board.getSections().stream().map(BoardShortSectionDto::new).collect(Collectors.toList());
    }
}
