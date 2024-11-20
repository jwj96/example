package com.example.example.repository;

import com.example.example.domain.Event;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EventRepository {
    private static final Map<Integer, Event> list=new HashMap<>();
    private static int sequence=0;

    public void save(Event event){
        event.setId(++sequence);
        list.put(event.getId(), event);
    }
    public void delete(int id){
        list.remove(id);
    }
    public List<Event> findAll() {
        return new ArrayList<>(list.values());
    }
    public void edit(int id, Event event){
        list.put(id, event);
    }
    public Event findById(int id) {
        return list.get(id);
    }
}
