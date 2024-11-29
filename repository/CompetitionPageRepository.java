package com.example.joinup.competitionboard.repository;

import com.example.joinup.competitionboard.entity.CompetitionPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionPageRepository extends JpaRepository<CompetitionPage, Integer> {
}
