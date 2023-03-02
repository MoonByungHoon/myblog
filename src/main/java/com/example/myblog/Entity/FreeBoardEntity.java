package com.example.myblog.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "freeboard")
public class FreeBoardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity writer;

  @Column(name = "title", nullable = false, length = 60)
  private String title;

  @Column(name = "content", nullable = false, length = 2000)
  private String content;

  @Column(name = "img_url")
  private String imgUrl;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "freeBoard")
  private List<FreeBoardReplyEntity> replys = new ArrayList<>();

  public void addReply(FreeBoardReplyEntity reply){
    this.replys.add(reply);
    reply.setFreeBoard(this);
  }
}
