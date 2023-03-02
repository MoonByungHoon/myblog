package com.example.myblog.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfoEntity {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToOne(fetch = FetchType.EAGER)
  @MapsId
  @JoinColumn(name = "id", referencedColumnName = "id")
  private UserEntity user;

  @Column(name = "phone_number", nullable = false, length = 256)
  private String phoneNumber;

  @Column(name = "real_name", nullable = false, length = 256)
  private String realName;

  @Column(name = "email", nullable = false, length = 256)
  private String email;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "email", referencedColumnName = "email")
  private EmailConfigEntity emailConfig;

  @Column(name = "auth_code", length = 30)
  private String authCode;
}
