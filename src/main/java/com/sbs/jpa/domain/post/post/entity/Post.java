package com.sbs.jpa.domain.post.post.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Post {
  // long => null 이 안됨
  // Long => null 이 됨
  // JPA 엔티티 클래스 특성상 id 필드 null이 가능하도록
  @Id // PRIMARY KEY
  @GeneratedValue(strategy = IDENTITY) // AUTO_INCREMENT
  private Long id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  @Column(length = 100)
  private String subject;
  @Column(columnDefinition = "TEXT")
  private String content;
  private boolean blind;
}
