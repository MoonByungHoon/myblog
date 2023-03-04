package com.example.myblog.Dto;

import com.example.myblog.Entity.FreeBoardEntity;
import com.example.myblog.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreeBoardDto {

  private Long id;
  private UserEntity writer;
  private String title;
  private String content;
  private String imgUrl;
  private LocalDate createdDate;
  private LocalDate modifiedDate;

  public FreeBoardDto(final FreeBoardEntity freeBoard) {
    this.id = freeBoard.getId();
    this.writer = freeBoard.getWriter();
    this.title = freeBoard.getTitle();
    this.content = freeBoard.getContent();
    this.imgUrl = freeBoard.getImgUrl();
    this.createdDate = freeBoard.getCreatedDate();
    this.modifiedDate = freeBoard.getModifiedDate();
  }

  public static FreeBoardEntity toEntity(final FreeBoardDto freeBoardDto) {
    return FreeBoardEntity.builder()
            .id(freeBoardDto.getId())
            .writer(freeBoardDto.getWriter())
            .title(freeBoardDto.getTitle())
            .content(freeBoardDto.getContent())
            .imgUrl(freeBoardDto.getImgUrl())
            .build();
  }
}