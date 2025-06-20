package com.sbs.jpa.domain.post.post.service;

import com.sbs.jpa.domain.post.post.entity.Post;
import com.sbs.jpa.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public Post write(String subject, String content) {
    Post post = Post
        .builder()
        .subject(subject)
        .content(content)
        .blind(false)
        .build();

    postRepository.save(post);

    return post;
  }

  public long count() {
    return postRepository.count();
  }

  public Optional<Post> findById(long id) {
    return postRepository.findById(id);
  }

  public void modify(Post post, String subject, String content) {
    post.setSubject(subject);
    post.setContent(content);

    postRepository.save(post); // UPDATE 쿼리 실행됨
  }
}
