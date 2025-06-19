package com.sbs.jpa.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  @Column(length = 100)
  private String subject;
  @Column(columnDefinition = "TEXT")
  private String content;
  private boolean blind;
}
