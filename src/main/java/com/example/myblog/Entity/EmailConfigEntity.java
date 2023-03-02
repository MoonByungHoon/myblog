package com.example.myblog.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "email_config")
public class EmailConfigEntity {

  @Id
  @Column(name = "email", nullable = false, length = 256, unique = true)
  private String email;

  @Column(name = "auth_code", length = 30)
  private String authCode;

  @OneToOne(mappedBy = "email")
  @PrimaryKeyJoinColumn
  private UserInfoEntity userInfo;
}
