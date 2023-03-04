package com.example.myblog.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfoEntity extends BaseTimeEntity {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "id", referencedColumnName = "id")
  private UserEntity user;

  @Column(name = "phone_number", nullable = false, length = 256)
  private String phoneNumber;

  @Column(name = "real_name", nullable = false, length = 256)
  private String realName;

  @Column(name = "email", nullable = false, length = 256)
  private String email;

  @Column(name = "auth_code", length = 30)
  private String authCode;
}