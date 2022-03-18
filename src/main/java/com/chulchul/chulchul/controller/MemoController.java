package com.chulchul.chulchul.controller;

import com.chulchul.chulchul.domain.Memo;
import com.chulchul.chulchul.domain.MemoRepository;
import com.chulchul.chulchul.domain.MemoRequestDto;
import com.chulchul.chulchul.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor//final 이니까 이거 해준다
public class MemoController {
    //생성,조회,삭제,변경
    //update 를 위해서는 service
    //나머지는 repository

    private final MemoRepository memoRepository; //필수적인 애들이기 때문에 private final
    private final MemoService memoService;

    //create
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo); //requestDto 의 내용을 repository 에 저장해주기
    }

    //read
    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
       return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    //delete
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){ //path 에 있는거 가져오기
        memoRepository.deleteById(id);
        return id;
    }

    //update
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id,requestDto);
        return id;
    }
}
