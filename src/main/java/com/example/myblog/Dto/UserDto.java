package com.example.myblog.Dto;

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
public class UserDto {

  private Long id;
  private String username;
  private String password;
  private String nickname;
  private LocalDate createdDate;
  private LocalDate modifiedDate;

  public UserDto(final UserEntity user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.nickname = user.getNickname();
    this.createdDate = user.getCreatedDate();
    this.modifiedDate = user.getModifiedDate();
  }

  public static UserEntity toEntity(final UserDto userDto) {
    return UserEntity.builder()
            .id(userDto.getId())
            .username(userDto.getUsername())
            .password(userDto.getPassword())
            .nickname(userDto.getNickname())
            .build();
  }
}