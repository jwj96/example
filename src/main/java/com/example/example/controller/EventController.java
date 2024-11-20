package com.example.example.controller;

import com.example.example.domain.Event;
import com.example.example.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    //홈 화면 구성
    @GetMapping(value="/")
    public String home(Model model) {
        model.addAttribute("list", eventService.getAll());
        return "home";
    }
    //글쓰기 화면
    @GetMapping("/content/write")
    public String writePage(){
        return "write";
    }
    @PostMapping("/content/write")
    public String writeContent(Event event){
        LocalDateTime now=LocalDateTime.now();
        String formatDate=now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        event.setDate(formatDate);
        eventService.writeEvent(event);
        return "redirect:/";
    }
    //한 개의 글 보기 화면
    @GetMapping("/content/{id}")
    public String showEvent(@PathVariable int id, Model model){
        model.addAttribute("event", eventService.getOne(id));
        return "read";
    }
    //글 수정 화면
    @PostMapping("/content/{id}")
    public String editEvent(@PathVariable int id, Event event){
        eventService.editEvent(id, event.getEventTitle(), event.getEventContent(), event.getWriter(), event.getEventDate());
        return "redirect:/";
    }
    //글 삭제
    @PostMapping("/content/delete/{id}")
    public String deleteEvent(@PathVariable int id, Event event) {
        eventService.deleteEvent(id);
        return "redirect:/";
    }
}
