package com.example.myblog.Dto;

import com.example.myblog.Entity.EmailConfigEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailConfigDto {

  private String email;
  private String authCode;
  private LocalDate createdDate;
  private LocalDate modifiedDate;

  public EmailConfigDto(final EmailConfigEntity emailConfigEntity) {
    this.email = emailConfigEntity.getEmail();
    this.authCode = emailConfigEntity.getAuthCode();
    this.createdDate = emailConfigEntity.getCreatedDate();
    this.modifiedDate = emailConfigEntity.getModifiedDate();
  }

  public static EmailConfigEntity toEntity(final EmailConfigDto emailConfigDto) {
    return EmailConfigEntity.builder()
            .email(emailConfigDto.getEmail())
            .authCode(emailConfigDto.getEmail())
            .build();
  }
}