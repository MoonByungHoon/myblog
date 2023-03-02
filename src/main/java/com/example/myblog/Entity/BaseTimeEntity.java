package com.example.myblog.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//엔티티가 삽입, 삭제, 수정, 조회 등 작업될 때에 이를 감지하고 자동 처리되기 위한 어노테이션이다.
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

  @CreatedDate
  //Auditing에서 데이터가 생성될 때에 업데이트를 해주길 바라는 변수에 사용한다.
  @Column
  private LocalDateTime createdDate;

  @LastModifiedDate
  //Auditing에서 데이터가 업데이트될 때에 업데이트 해주길 바라는 변수에 사용한다.
  //이 외에 @CreatedBy, @LastModifiedBy도 존재한다.
  @Column
  private LocalDateTime modifiedDate;

}
