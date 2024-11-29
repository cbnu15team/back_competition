package com.example.joinup.competitionboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "competition_page")
public class CompetitionPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private Integer pageId;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private CompetitionBoard competitionBoard;

    @Column(name = "created_at", nullable = false) // 작성 시간
    private LocalDateTime createdAt;

    @Transient
    private String title;    // 제목

    @Transient
    private String author;    // 작성자

    @Transient
    private Integer views;    // 조회수
}
