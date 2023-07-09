package com.lsb.hj01.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lsb.hj01.domain.Board;
import com.lsb.hj01.dto.BoardDTO;
import com.lsb.hj01.dto.BoardListRcntDTO;
import com.lsb.hj01.dto.PageRequestDTO;
import com.lsb.hj01.dto.PageResponseDTO;
import com.lsb.hj01.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@CrossOrigin
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "/list")
    public PageResponseDTO<BoardListRcntDTO> list(
        @ParameterObject PageRequestDTO requestDTO) {

        log.info(requestDTO);

        return boardService.listRcnt(requestDTO);
    }
    
    @GetMapping("/{bno}")
    public BoardDTO get(@PathVariable("bno") Long bno){

        return boardService.getOne(bno);
    }

    @PostMapping("/regist")
    public Long regist(@RequestBody Board board){
        
        return boardService.register(board);
    }
    
    @PutMapping("/modify")
    public Long modify(@RequestBody Board board){

        return boardService.modifier(board);
    }

    @DeleteMapping("/delete/{bno}")
    public Long delete(@PathVariable("bno") Long bno){

        return boardService.delete(bno);
    }

}
