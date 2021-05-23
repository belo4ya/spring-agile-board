package com.example.agileboard.controllers;

import com.example.agileboard.dto.board.BoardDto;
import com.example.agileboard.dto.board.BoardSectionDto;
import com.example.agileboard.dto.board.BoardSectionTaskDto;
import com.example.agileboard.dto.task.TaskDto;
import com.example.agileboard.exceptions.ResourceNotFoundException;
import com.example.agileboard.models.Board;
import com.example.agileboard.models.Section;
import com.example.agileboard.models.Task;
import com.example.agileboard.repositories.BoardRepository;
import com.example.agileboard.repositories.SectionRepository;
import com.example.agileboard.repositories.TaskRepository;
import com.example.agileboard.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AgileController {
    private final BoardRepository boardRepository;
    private final SectionRepository sectionRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public AgileController(BoardRepository boardRepository, SectionRepository sectionRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.sectionRepository = sectionRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/boards")
    public List<BoardDto> getBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardDto::new).collect(Collectors.toList());
    }

    @GetMapping("/boards/{id}")
    public BoardDto getBoard(@PathVariable Long id) {
        Board board = boardRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return new BoardDto(board);
    }

    @GetMapping("/boards/{id}/sections")
    public List<BoardSectionDto> getBoardSections(@PathVariable Long id) {
        List<Section> sections = sectionRepository.findByBoardId(id);
        return sections.stream().map(BoardSectionDto::new).collect(Collectors.toList());
    }

    @GetMapping("/boards/{boardId}/sections/{sectionId}")
    public BoardSectionDto getBoardSection(@PathVariable Long boardId, @PathVariable Long sectionId) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(ResourceNotFoundException::new);
        return new BoardSectionDto(section);
    }
}
