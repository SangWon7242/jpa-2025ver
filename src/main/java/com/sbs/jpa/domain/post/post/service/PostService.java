package com.sbs.jpa.domain.post.post.service;

import com.sbs.jpa.domain.post.post.entity.Post;
import com.sbs.jpa.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public Post write(String subject, String content) {
    Post post = new Post();
    // id는 자동 생성되므로 설정하지 않음
    post.setCreatedAt(LocalDateTime.now());
    post.setModifiedAt(LocalDateTime.now());
    post.setSubject(subject);
    post.setContent(content);
    post.setBlind(false);

    postRepository.save(post);

    return post;
  }

  public long count() {
    return postRepository.count();
  }
}
