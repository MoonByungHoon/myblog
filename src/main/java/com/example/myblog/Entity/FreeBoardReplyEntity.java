package com.example.myblog.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "freeboard_reply")
public class FreeBoardReplyEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "content", length = 1000)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity writer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "freeboard_id", nullable = false)
  private FreeBoardEntity freeBoardId;

  public void setWriter(final UserEntity user) {
    this.writer = user;
  }

  public void setFreeBoard(final FreeBoardEntity freeBoard) {
    this.freeBoardId = freeBoard;
  }
}