package com.lsb.hj01.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lsb.hj01.domain.Board;
import com.lsb.hj01.domain.Reply;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    
    @Autowired
    private ReplyRepository replyrepository;

    @Test
    public void testInsertDummies(){

        Long[] bnoArr = {200L, 198L, 196L, 190L, 188L, 185L};

        for(Long bno : bnoArr) {

            Board board = Board.builder().bno(bno).build();

            for(int i = 0; i < 51; i++){

                Reply reply = Reply.builder()
                    .replyText("Reply..." + bno + "--" + i)
                    .replyer("replyer"+i)
                    .board(board)
                    .build();

                replyrepository.save(reply);

            }

        } // end for

    }



}
