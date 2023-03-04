package com.example.myblog.Dto;

import com.example.myblog.Entity.UserInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

  private Long id;
  private String phoneNumber;
  private String realName;
  private String email;
  private String authCode;
  private LocalDate createdDate;
  private LocalDate modifiedDate;

  public UserInfoDto(final UserInfoEntity userInfo) {
    this.id = userInfo.getId();;
    this.phoneNumber = userInfo.getPhoneNumber();
    this.realName = userInfo.getRealName();
    this.email = userInfo.getEmail();
    this.authCode = userInfo.getAuthCode();
    this.createdDate = userInfo.getCreatedDate();
    this.modifiedDate = userInfo.getModifiedDate();
  }

  public static UserInfoEntity toEntity(final UserInfoDto userInfoDto) {
    return UserInfoEntity.builder()
            .id(userInfoDto.getId())
            .phoneNumber(userInfoDto.getPhoneNumber())
            .realName(userInfoDto.getRealName())
            .email(userInfoDto.getEmail())
            .authCode(userInfoDto.getAuthCode())
            .build();
  }
}