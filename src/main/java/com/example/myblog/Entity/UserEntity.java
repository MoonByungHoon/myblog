package com.example.myblog.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "username", nullable = false, unique = true, length = 45)
  private String username;

  @Column(name = "password", nullable = false, length = 256)
  private String password;

  @Column(name = "nickname", nullable = false, length = 30, unique = true)
  private String nickname;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
  @PrimaryKeyJoinColumn
  private UserInfoEntity userInfo;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "writer")
  private List<FreeBoardEntity> freeboards = new ArrayList<>();

  public void addFreeboard(final FreeBoardEntity freeBoard) {
    this.freeboards.add(freeBoard);
    freeBoard.setWriter(this);
  }

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "writer")
  private List<FreeBoardReplyEntity> replys = new ArrayList<>();

  public void addReply(final FreeBoardReplyEntity reply) {
    this.replys.add(reply);
    reply.setWriter(this);
  }
}