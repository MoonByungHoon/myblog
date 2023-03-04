package com.example.myblog.Dto;

import com.example.myblog.Entity.FreeBoardEntity;
import com.example.myblog.Entity.FreeBoardReplyEntity;
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
public class FreeBoardReplyDto {

  private Long id;
  private String content;
  private UserEntity writer;
  private FreeBoardEntity freeBoardId;
  private LocalDate createdDate;
  private LocalDate modifiedDate;

  public FreeBoardReplyDto(final FreeBoardReplyEntity reply) {
    this.id = reply.getId();
    this.content = reply.getContent();
    this.writer = reply.getWriter();
    this.freeBoardId = reply.getFreeBoardId();
    this.createdDate = reply.getCreatedDate();
    this.modifiedDate = reply.getModifiedDate();
  }

  public static FreeBoardReplyEntity toEntity(final FreeBoardReplyDto freeBoardReplyDto) {
    return FreeBoardReplyEntity.builder()
            .id(freeBoardReplyDto.getId())
            .content(freeBoardReplyDto.getContent())
            .writer(freeBoardReplyDto.getWriter())
            .freeBoardId(freeBoardReplyDto.getFreeBoardId())
            .build();
  }
}