package com.example.example.service;

import com.example.example.domain.Event;
import com.example.example.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.processor.SpringUErrorsTagProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    //글 작성
    public void writeEvent(Event event){
        eventRepository.save(event);
    }
    //글 수정
    public void editEvent(int id, String title, String content, String writer, String eventDate) {
        Event event=eventRepository.findById(id);
        event.setEventTitle(title);
        event.setEventContent(content);
        event.setWriter(writer);
        event.setEventDate(eventDate);
        LocalDateTime now=LocalDateTime.now();
        String formatDate=now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        event.setDate(formatDate);
        eventRepository.edit(id, event);
    }
    //글 삭제
    public void deleteEvent(int id) {
        Event event=eventRepository.findById(id);
        eventRepository.delete(id);
    }
    //글 전체 조회
    public List<Event> getAll(){
        return eventRepository.findAll();
    }
    //글 하나만 id값으로 조회
    public Event getOne(int id){
        return eventRepository.findById(id);
    }
}
