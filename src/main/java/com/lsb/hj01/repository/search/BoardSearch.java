package com.lsb.hj01.repository.search;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.lsb.hj01.dto.BoardListRcntDTO;
import com.lsb.hj01.dto.PageRequestDTO;
import com.lsb.hj01.dto.PageResponseDTO;

public interface BoardSearch {

    PageResponseDTO<BoardListRcntDTO> searchDTORcnt(PageRequestDTO requestDTO);

    default Pageable makePageable(PageRequestDTO requestDTO){

        Pageable pageable =  PageRequest.of(
            requestDTO.getPage() -1,
            requestDTO.getSize(),
            Sort.by("bno").descending());

        return pageable;
    }
}
