package com.lsb.hj01.service;

import com.lsb.hj01.domain.Board;
import com.lsb.hj01.dto.BoardDTO;
import com.lsb.hj01.dto.BoardListRcntDTO;
import com.lsb.hj01.dto.PageRequestDTO;
import com.lsb.hj01.dto.PageResponseDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardService {

    PageResponseDTO<BoardListRcntDTO> listRcnt(PageRequestDTO pageRequestDTO);

    BoardDTO getOne(Long bno);

    Long register(Board board);

    Long modifier(Board board);

    Long delete(Long bno);
    
}
