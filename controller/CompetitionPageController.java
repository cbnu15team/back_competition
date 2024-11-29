package com.example.joinup.competitionboard.controller;

import com.example.joinup.competitionboard.entity.CompetitionBoard;
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
    public ResponseEntity<List<CompetitionPage>> getAllPages() {
        try {
            List<CompetitionPage> pages = competitionPageService.getAllPages();

            pages.forEach(page -> {
                CompetitionBoard board = page.getCompetitionBoard();
                page.setTitle(board.getTitle());
                page.setAuthor(board.getUser().getId()); // 작성자(User ID)
                page.setViews(board.getViews());
            });

            return ResponseEntity.ok(pages);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPage(@RequestBody CompetitionPage page) {
        try {
            CompetitionPage createdPage = competitionPageService.createPage(page);
            CompetitionBoard board = createdPage.getCompetitionBoard();
            createdPage.setTitle(board.getTitle());
            createdPage.setAuthor(board.getUser().getId());
            createdPage.setViews(board.getViews());
            return ResponseEntity.ok(createdPage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("CompetitionPage 생성 실패: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPageById(@PathVariable Integer id) {
        try {
            CompetitionPage page = competitionPageService.getPageById(id);
            CompetitionBoard board = page.getCompetitionBoard();
            page.setTitle(board.getTitle());
            page.setAuthor(board.getUser().getId());
            page.setViews(board.getViews());
            return ResponseEntity.ok(page);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("CompetitionPage 조회 실패: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePageById(@PathVariable Integer id) {
        try {
            competitionPageService.deletePageById(id);
            return ResponseEntity.ok("CompetitionPage가 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("CompetitionPage 삭제 실패: " + e.getMessage());
        }
    }
}
