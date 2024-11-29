package com.example.joinup.competitionboard.service;

import com.example.joinup.competitionboard.entity.CompetitionPage;
import com.example.joinup.competitionboard.repository.CompetitionPageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionPageService {

    private final CompetitionPageRepository competitionPageRepository;

    public CompetitionPageService(CompetitionPageRepository competitionPageRepository) {
        this.competitionPageRepository = competitionPageRepository;
    }

    public List<CompetitionPage> getAllPages() {
        return competitionPageRepository.findAll();
    }

    public CompetitionPage updatePage(Integer id, CompetitionPage updatedPage) {
        CompetitionPage existingPage = competitionPageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 페이지를 찾을 수 없습니다. ID: " + id));

        existingPage.setCreatedAt(updatedPage.getCreatedAt());
        return competitionPageRepository.save(existingPage);
    }
}
