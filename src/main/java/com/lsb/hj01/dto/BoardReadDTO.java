package com.lsb.hj01.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface BoardReadDTO {
    
    Long getBno();
    String getTitle();
    String getContent();
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    LocalDateTime getRegDate();
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    LocalDateTime getModDate();

}