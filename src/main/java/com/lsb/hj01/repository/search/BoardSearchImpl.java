package com.lsb.hj01.repository.search;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.lsb.hj01.domain.Board;
import com.lsb.hj01.domain.QBoard;
import com.lsb.hj01.domain.QReply;
import com.lsb.hj01.dto.BoardListRcntDTO;
import com.lsb.hj01.dto.PageRequestDTO;
import com.lsb.hj01.dto.PageResponseDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch{

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public PageResponseDTO<BoardListRcntDTO> searchDTORcnt(PageRequestDTO requestDTO) {

        Pageable pageable = makePageable(requestDTO);

        QBoard board = QBoard.board;
        QReply reply = QReply.reply;

        JPQLQuery<Board> query = from(board);
        // left outer join
        query.leftJoin(reply).on(reply.board.eq(board));

        String keyword = requestDTO.getKeyword();
        String searchType = requestDTO.getType();

        if(keyword != null && searchType != null){

            // tc -> [t, c]
            String[] searchArr = searchType.split("");

            // 우선순위 연산자 ( ... ) ...
            BooleanBuilder searchBuilder = new BooleanBuilder();

            for (String type : searchArr) {
                switch(type) {
                    // or연산
                    case "t" -> searchBuilder.or(board.title.contains(keyword));
                    case "c" -> searchBuilder.or(board.content.contains(keyword));
                    case "w" -> searchBuilder.or(board.writer.contains(keyword));
                }
            } // end for

            query.where(searchBuilder);
        }

        this.getQuerydsl().applyPagination(pageable, query);
        query.groupBy(board);

        // 오늘 중요 포인트
        JPQLQuery<BoardListRcntDTO> listQuery = query.select(
            Projections.bean(BoardListRcntDTO.class, 
                board.bno, 
                board.title,
                board.writer,
                reply.countDistinct().as("replyCount"))
            );

        
        List<BoardListRcntDTO> list = listQuery.fetch();

        log.info("------------------------");
        log.info(list);

        long totalCount = listQuery.fetchCount();

        return new PageResponseDTO<>(list, totalCount, requestDTO);
    }
    
}
