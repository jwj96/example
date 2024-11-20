package com.example.example.domain;

import lombok.*;

//@NoArgsConstructor : 파라미터가 없는 디폴트 생성자를 생성
//@AllArgsConstructor : 모든 필드 값을 파라미터로 받는 생성자를 생성
//@RequiredArgsConstructor : final이나 @NonNull으로 선언된 필드만을 파라미터로 받는 생성자를 생성
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {
    private int id;
    private String eventTitle;
    private String eventContent;
    private String writer;
    private String eventDate;
    private String date;
}
