package com.example.joinup.competitionboard.controller;

import com.example.joinup.competitionboard.entity.CompetitionPage;
import com.example.joinup.competitionboard.service.CompetitionPageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition-pages")
public class CompetitionPageController {

    private final CompetitionPageService competitionPageService;

    public CompetitionPageController(CompetitionPageService competitionPageService) {
        this.competitionPageService = competitionPageService;
    }

    @GetMapping
    public List<CompetitionPage> getAllPages() {
        return competitionPageService.getAllPages();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePage(@PathVariable Integer id, @RequestBody CompetitionPage updatedPage) {
        try {
            CompetitionPage page = competitionPageService.updatePage(id, updatedPage);
            return ResponseEntity.ok(page);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("페이지 수정 실패: " + e.getMessage());
        }
    }
}
