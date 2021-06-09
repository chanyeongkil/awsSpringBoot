package com.aws.springboot.domain.posts;

// Entity 클래스

import com.aws.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;

@EnableJpaAuditing
@SpringBootApplication
@Getter // Lombok
@NoArgsConstructor // Lombok
@Entity // JPA 어노테이션
/*
* 실제 DB 테이블과 매칭 될 클래스 Entity 클래스라 함
* JPA 에서는 Entity 클래스틑 통해 DB와 인터페이스 함
* 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍 으로 테이블 이름을 매칭 함 ex> SalesManager.java >> sales_manager 테이블
*/

public class Posts extends BaseTimeEntity { // 실제 DB와 매칭 될 클래스 이다
    @Id // 해당 테이블의 PK필드를 나타 냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙, 스프링 부트 버전별 차이가 존재 함
    private Long id;

    // Column은 테이블의 컬럼을 나타냄, 선언하지 않아도 선언된 모든 필드는 컬럼으로 사용 됨
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder // Lombok
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
