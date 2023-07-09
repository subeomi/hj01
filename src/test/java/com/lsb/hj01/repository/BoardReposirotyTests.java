package com.lsb.hj01.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lsb.hj01.domain.Board;
import com.lsb.hj01.dto.BoardListRcntDTO;
import com.lsb.hj01.dto.PageRequestDTO;
import com.lsb.hj01.dto.PageResponseDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardReposirotyTests {
    
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert(){
        for(int i = 0; i < 200; i++){
            Board board = Board.builder()
            .title("Sample Title" + i)
            .content("Sample Content" + i)
            .writer("user"+(i % 10))
            .build();

            boardRepository.save(board);
        }
    }

    @Test
    public void testRead(){

        Long bno = 200L;

        Optional<Board> result = boardRepository.findById(bno);

        log.info("Read----------------");

        Board board = result.orElseThrow();

        log.info(board);
    }

    @Test
    public void testUpdate(){

        Long bno = 200L;

        Optional<Board> result = boardRepository.findById(bno);

        log.info("Update Test -----------------");

        Board board = result.orElseThrow();

        board.changeTitle("Title"+bno);

        boardRepository.save(board);
    }

    @Test
    public void testQuery1(){

        List<Board> list = boardRepository.findByTitleContaining("1");

        log.info("----------------------------------------");
        log.info(list.size());
        log.info(list);

    }

    @Test
    public void testGetListWithRcnt(){

        List<Object[]> result = boardRepository.getListWithRcnt();

        for (Object[] result2 : result) {
            log.info(Arrays.toString(result2));
        }

    }

    @Test
    public void test0706_1(){

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResponseDTO<BoardListRcntDTO> responseDTO = 
            boardRepository.searchDTORcnt(pageRequestDTO);

        log.info(responseDTO);

    }

}
