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
    @JoinColumn(name = "competition_id", nullable = false) // CompetitionBoard를 참조
    private CompetitionBoard competitionBoard;

    @Column(name = "created_at", nullable = false) // CompetitionPage 생성 시간
    private LocalDateTime createdAt;

    @Transient
    private String title;

    @Transient
    private String author;

    @Transient
    private Integer views;
}