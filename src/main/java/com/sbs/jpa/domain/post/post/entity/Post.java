package com.sbs.jpa.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Post {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(updatable = false) // updatable = false : 생성 시에만 값이 설정되고 이후에는 변경되지 않음
  @Setter(AccessLevel.PRIVATE) // Private 필드에 대해서는 setter를 생성하지 않음
  private Long id;

  @CreatedDate
  @Column(updatable = false)
  @Setter(AccessLevel.PRIVATE)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Setter(AccessLevel.PRIVATE)
  private LocalDateTime modifiedAt;
  @Column(length = 100)
  private String subject;
  @Column(columnDefinition = "TEXT")
  private String content;
  private boolean blind;
}
