package com.example.joinup.competitionboard.service;

import com.example.joinup.competitionboard.entity.CompetitionBoard;
import com.example.joinup.competitionboard.repository.CompetitionBoardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompetitionBoardService {

    private final CompetitionBoardRepository competitionBoardRepository;

    public CompetitionBoardService(CompetitionBoardRepository competitionBoardRepository) {
        this.competitionBoardRepository = competitionBoardRepository;
    }

    public List<CompetitionBoard> getAllBoards() {
        return competitionBoardRepository.findAll();
    }

    public CompetitionBoard getBoardById(Integer id) {
        return competitionBoardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 게시글을 찾을 수 없습니다. ID: " + id));
    }

    public CompetitionBoard createBoard(CompetitionBoard board) {
        board.setCreatedAt(LocalDateTime.now());
        board.setViews(0);
        return competitionBoardRepository.save(board);
    }

    public CompetitionBoard updateBoard(Integer id, CompetitionBoard updatedBoard) {
        CompetitionBoard existingBoard = competitionBoardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 게시글을 찾을 수 없습니다. ID: " + id));

        existingBoard.setTitle(updatedBoard.getTitle());
        existingBoard.setContent(updatedBoard.getContent());
        return competitionBoardRepository.save(existingBoard);
    }

    public void deleteBoardById(Integer id) {
        competitionBoardRepository.deleteById(id);
    }
}
