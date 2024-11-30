package com.example.joinup.competitionboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "competition_board")
public class CompetitionBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Integer boardId;

    @OneToOne
    @JoinColumn(name = "page_id", nullable = false) // CompetitionPage와 연결
    private CompetitionPage competitionPage;

    @Transient // CompetitionPage에서 제목 가져오기
    private String title;

    @Transient // CompetitionPage에서 작성자 닉네임 가져오기
    private String nickname;

    @Transient // CompetitionPage에서 작성일 가져오기
    private LocalDateTime createdAt;

    @Transient // CompetitionPage에서 조회수 가져오기
    private Integer views;

    @PostLoad
    public void loadFromCompetitionPage() {
        if (competitionPage != null) {
            this.title = competitionPage.getTitle();
            this.nickname = competitionPage.getNickname();
            this.createdAt = competitionPage.getCreatedAt();
            this.views = competitionPage.getViews();
        }
    }
}
