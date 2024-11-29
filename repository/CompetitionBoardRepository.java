package com.example.joinup.competitionboard.repository;

import com.example.joinup.competitionboard.entity.CompetitionBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionBoardRepository extends JpaRepository<CompetitionBoard, Integer> {
}
