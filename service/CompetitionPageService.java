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

    public CompetitionPage createPage(CompetitionPage page) {
        return competitionPageRepository.save(page);
    }

    public CompetitionPage getPageById(Integer id) {
        return competitionPageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CompetitionPage를 찾을 수 없습니다. ID: " + id));
    }

    public void deletePageById(Integer id) {
        CompetitionPage page = competitionPageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CompetitionPage를 찾을 수 없습니다. ID: " + id));
        competitionPageRepository.delete(page);
    }
}
