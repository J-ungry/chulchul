package com.chulchul.chulchul.service;

import com.chulchul.chulchul.domain.Memo;
import com.chulchul.chulchul.domain.MemoRepository;
import com.chulchul.chulchul.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //final 로 선언된 애 있으면 무조건 해줄게
@Service
public class MemoService {

    private final MemoRepository memoRepository; //final = 꼭 필요하다 !

    @Transactional //이거 진짜 db에 반영해야해 ~!~!
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}