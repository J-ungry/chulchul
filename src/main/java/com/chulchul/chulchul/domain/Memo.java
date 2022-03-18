package com.chulchul.chulchul.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //생성자 기본으로 만들어주는거
@Entity //테이블과 연계됨을 스프링한테 알려주기

public class Memo extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO) //id 값 자동으로 생성하는거
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;


    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents){
        this.username = username;
        this.contents = contents;
    }
    public Memo(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
