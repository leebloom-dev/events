package com.events.events.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.events.events.models.EventModel;

public class EventData {
    
    private static final Map<Integer, EventModel> events = new HashMap<>();

    // Collection extents to Iterable interface.
    // behavior: loop over a collection
    public static Collection<EventModel> getAll() {
        return events.values();
    }

    public static EventModel getById(int id) {
        return events.get(id);
    }

    public static void add(EventModel event) {
        events.put(event.getId(), event);
    }

    public static void remove(int id) {
        events.remove(id);
    }

}
