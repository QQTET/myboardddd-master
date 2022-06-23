package com.example.myboard.controller;

import com.example.myboard.model.Board;
import com.example.myboard.repository.BoardRepository;
import com.example.myboard.service.Boardservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private Boardservice boardService;
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }
    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("board", new Board());
            }else{
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }
        return "board/form";
    }
    @PostMapping("/form")
    public String form2(@ModelAttribute Board board){
        boardRepository.save(board);
       return "redirect:/board/list";
    }

    @DeleteMapping("/board/{id}")
    public String boardDelete(@PathVariable("id") Long id){
        boardService.boardDelete(id);
       return "redirect:/board/list";
    }

}
