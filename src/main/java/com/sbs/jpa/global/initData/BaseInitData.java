package com.sbs.jpa.global.initData;

import com.sbs.jpa.domain.post.post.entity.Post;
import com.sbs.jpa.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
  private final PostService postService;

  @Bean
  @Order(1) // Order 값이 낮을수록 먼저 실행됨
  public ApplicationRunner baseInitData1ApplicationRunner () {
    return args -> {
      System.out.println("BaseInitData1ApplicationRunner 실행됨");

      if ( postService.count() > 0 ) return;

      Post post1 = postService.write("title1", "content1");
      Post post2 = postService.write("title2", "content2");
      Post post3 = postService.write("title3", "content3");
    };
  }

  @Bean
  @Order(2)
  public ApplicationRunner baseInitData2ApplicationRunner () {
    return args -> {
      Post post1 = postService.findById(1L).get();
    };
  }
}
