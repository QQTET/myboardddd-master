package com.example.myboard.service;

import com.example.myboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Boardservice {

    @Autowired
    private BoardRepository boardRepository;

    public void boardDelete(Long id){
        boardRepository.deleteById(id);
    }
}
