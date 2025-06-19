package com.sbs.jpa.global.initData;

import com.sbs.jpa.domain.post.post.entity.Post;
import com.sbs.jpa.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
  private final PostService postService;

  @Bean
  public ApplicationRunner BaseInutDataApplicationRunner () {
    return args -> {
      Post post1 = postService.write("title1", "content1");
      System.out.printf("%d번 글이 생성 됨\n", post1.getId());

      Post post2 = postService.write("title2", "content2");
      System.out.printf("%d번 글이 생성 됨\n", post2.getId());

      Post post3 = postService.write("title3", "content3");
      System.out.printf("%d번 글이 생성 됨\n", post3.getId());
    };
  }
}
