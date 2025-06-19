package com.sbs.jpa.domain.post.repository;

import com.sbs.jpa.domain.post.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// Post: 이 클래스로 다룰 엔티티 클래스와 연동된 테이블(Post 테이블)을 지정
// Long: 엔티티 클래스의 ID 타입을 지정
public interface PostRepository extends JpaRepository<Post, Long> {
}
