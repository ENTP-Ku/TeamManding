package com.example.demo; // 패키지 선언

import java.time.LocalDateTime; // 날짜와 시간을 다루기 위한 import
import jakarta.persistence.Entity; // JPA 엔티티를 나타내기 위한 import
import jakarta.persistence.GeneratedValue; // 자동 생성된 값 설정을 위한 import
import jakarta.persistence.GenerationType; // 생성 전략을 설정하기 위한 import
import jakarta.persistence.Id; // ID 필드를 나타내기 위한 import
import jakarta.persistence.ManyToOne; // 다대일 관계를 나타내기 위한 import
import lombok.Data; // Lombok의 @Data 어노테이션을 사용하기 위한 import

// 제품 정보를 나타내는 JPA 엔티티 클래스
@Entity // JPA가 이 클래스를 엔티티로 인식하도록 설정
@Data // 모든 필드에 대한 getter, setter 및 toString, equals, hashCode 메소드 자동 생성
public class Product {
    @Id // 이 필드는 엔티티의 기본 키임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 값이 자동으로 생성됨
    private Long id; // 제품의 고유 ID

    private String imagePath; // 제품 이미지 경로 (문자열)
    private String name; // 제품명
    private Integer price; // 제품 가격
    private String kind; // 제품 종류 (예: 'top' 또는 'bottom')
    private LocalDateTime uploadDate; // 제품이 업로드된 날짜와 시간

    @ManyToOne // 다대일 관계 설정 (여러 제품이 하나의 사용자에 속할 수 있음)
    private User uploaderId; // 업로더 (사용자) 정보
}
