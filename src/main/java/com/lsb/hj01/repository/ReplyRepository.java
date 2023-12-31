package com.lsb.hj01.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lsb.hj01.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
    
    // JPQL. 테이블 이름이 아닌 엔티티 이름으로
    @Query("select r from Reply r where r.board.bno = :bno")
    Page<Reply> listBoard(@Param("bno") Long bno, Pageable pageable);

    @Query("select count(r) from Reply r where r.board.bno = :bno")
    long getCountBoard(@Param("bno") Long bno);

}