package com.sbs.jpa.domain.post.post.service;

import com.sbs.jpa.domain.post.post.entity.Post;
import com.sbs.jpa.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public Post write(String subject, String content) {
    Post post = new Post(
        null,
        LocalDateTime.now(),
        LocalDateTime.now(),
        subject,
        content,
        false
    );

    postRepository.save(post);

    return post;
  }

  public long count() {
    return postRepository.count();
  }

  public Optional<Post> findById(long id) {
    return postRepository.findById(id);
  }
}
