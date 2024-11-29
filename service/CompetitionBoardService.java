package com.example.joinup.competitionboard.service;

import com.example.joinup.competitionboard.entity.CompetitionBoard;
import com.example.joinup.competitionboard.repository.CompetitionBoardRepository;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new RuntimeException("CompetitionBoard를 찾을 수 없습니다. ID: " + id));
    }

    public CompetitionBoard createBoard(CompetitionBoard board) {
        board.setCreatedAt(java.time.LocalDateTime.now());
        board.setViews(0); // 조회수 초기화
        return competitionBoardRepository.save(board);
    }

    public void deleteBoardById(Integer id) {
        competitionBoardRepository.deleteById(id);
    }
}
