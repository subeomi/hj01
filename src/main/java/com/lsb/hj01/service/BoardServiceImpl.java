package com.lsb.hj01.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lsb.hj01.domain.Board;
import com.lsb.hj01.dto.BoardDTO;
import com.lsb.hj01.dto.BoardListRcntDTO;
import com.lsb.hj01.dto.PageRequestDTO;
import com.lsb.hj01.dto.PageResponseDTO;
import com.lsb.hj01.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public PageResponseDTO<BoardListRcntDTO> listRcnt(PageRequestDTO pageRequestDTO) {
        
        return boardRepository.searchDTORcnt(pageRequestDTO);
    }

    @Override
    public BoardDTO getOne(Long bno) {
        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        BoardDTO dto = modelMapper.map(board, BoardDTO.class);

        return dto;
    }

    @Override
    public Long register(Board board) {
        Board result = boardRepository.save(board);

        return board.getBno();
    }

    @Override
    public Long modifier(Board board) {
        Optional<Board> result = boardRepository.findById(board.getBno());

        Board mod = result.orElseThrow();

        mod.changeContent(board.getContent());
        mod.changeTitle(board.getTitle());
        mod.changeWriter(board.getWriter());


        boardRepository.save(mod);

        return board.getBno();
    }

    @Override
    public Long delete(Long bno) {

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        boardRepository.delete(board);

        return board.getBno();
    }
    


}
