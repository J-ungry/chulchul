package com.chulchul.chulchul.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo,Long>{
    // memorepository 가 jpa 에서 제공하는 기능들을 갖다가 쓸거다 라는 뜻
    List<Memo> findAllByOrderByModifiedAtDesc(); //생성시간 최신순으로 정렬점 ㅋㅋ

}

