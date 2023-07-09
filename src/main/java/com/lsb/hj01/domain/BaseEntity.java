package com.lsb.hj01.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

// 테이블을 새로 만들지 말라는 의미의 어노테이션
// 추상클래스이다
@MappedSuperclass
@Getter
@EntityListeners(value = { AuditingEntityListener.class })
public abstract class BaseEntity {
    
    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;

    // JsonFormat을 넣어 LocalDateTime타입의 직/역직렬화 문제 해결...
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDate;

}