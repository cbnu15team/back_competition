package com.example.joinup.competitionboard.controller;

import com.example.joinup.competitionboard.entity.CompetitionBoard;
import com.example.joinup.competitionboard.service.CompetitionBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition-boards")
public class CompetitionBoardController {

    private final CompetitionBoardService competitionBoardService;

    public CompetitionBoardController(CompetitionBoardService competitionBoardService) {
        this.competitionBoardService = competitionBoardService;
    }

    @GetMapping
    public List<CompetitionBoard> getAllBoards() {
        return competitionBoardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable Integer id) {
        try {
            CompetitionBoard board = competitionBoardService.getBoardById(id);
            return ResponseEntity.ok(board);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody CompetitionBoard board) {
        try {
            CompetitionBoard createdBoard = competitionBoardService.createBoard(board);
            return ResponseEntity.ok(createdBoard);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("게시글 생성 실패: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Integer id, @RequestBody CompetitionBoard updatedBoard) {
        try {
            CompetitionBoard board = competitionBoardService.updateBoard(id, updatedBoard);
            return ResponseEntity.ok(board);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("게시글 수정 실패: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoardById(@PathVariable Integer id) {
        try {
            competitionBoardService.deleteBoardById(id);
            return ResponseEntity.ok("게시글이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("게시글 삭제 실패: " + e.getMessage());
        }
    }
}
