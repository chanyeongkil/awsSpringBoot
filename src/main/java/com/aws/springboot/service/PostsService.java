package com.aws.springboot.service;

import com.aws.springboot.domain.posts.Posts;
import com.aws.springboot.domain.posts.PostsRepository;
import com.aws.springboot.web.dto.PostsResponseDto;
import com.aws.springboot.web.dto.PostsSaveRequestDto;
import com.aws.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService { // 서비스 레이어에서는 트랜젝션의 순서 제어
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
       Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
       posts.update(requestDto.getTitle(), requestDto.getContent());
       return id;
    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
