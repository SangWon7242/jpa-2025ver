package com.sbs.jpa.domain.post.post.service;

import com.sbs.jpa.domain.post.post.entity.Post;
import com.sbs.jpa.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  @Transactional
  public void modify(Post post, String subject, String content) {
    Post pst = postRepository.findById(post.getId())
        .orElseThrow(() -> new IllegalArgumentException("%d번 게시물을 찾을 수 없습니다.".formatted(post.getId())));

    pst.setSubject(subject);
    pst.setContent(content);
  }
}
