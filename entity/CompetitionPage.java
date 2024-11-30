package com.example.joinup.competitionboard.entity;

import com.example.joinup.user.entity.User;
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
    @Column(name = "page_id") // 게시글 ID
    private Long pageId;

    @Column(name = "title", nullable = false, length = 100) // 게시글 제목
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT") // 게시글 내용
    private String content;

    @Column(name = "created_at", nullable = false) // 작성일
    private LocalDateTime createdAt;

    @Column(name = "views", nullable = false) // 조회수
    private int views;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // 작성자와 연결 (User의 userId 참조)
    private User user;

    // 작성자의 닉네임을 가져오기 위해 읽기 전용 필드로 설정
    @Transient
    private String nickname;

    @PostLoad
    public void setNicknameFromUser() {
        this.nickname = user != null ? user.getNickname() : null;
    }
}
