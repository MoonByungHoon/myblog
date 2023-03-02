package com.example.myblog.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "freeboard_reply")
public class FreeBoardReplyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "content", length = 1000)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity writer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "freeboard_id")
  private FreeBoardEntity freeBoard;
}
