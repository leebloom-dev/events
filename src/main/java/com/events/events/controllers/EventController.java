package com.events.events.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("events") // URL: localhost:8080/events
public class EventController {
    
    public static List<String> events = new ArrayList<>();

    // responds to GET requests at URL "/events"
    @GetMapping
    public String displayAllEvents() {
        return "/events/index";
    }

}
