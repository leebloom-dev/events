package com.events.events.controllers;

import java.util.ArrayList;
import java.util.List;

import com.events.events.models.EventModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("events") // URL: localhost:8080/events
public class EventController {
    
    public static List<EventModel> events = new ArrayList<>();

    // responds to GET requests at URL "/events"
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", events);
        return "/events/index";
    }

    // responds to GET requests at URL "/events/form"
    @GetMapping("form")
    public String displayEventForm() {
        return "/events/form";
    }

    // responds to POST requests at URL "/events/form"
    @PostMapping("form")
    public String processEventForm(@RequestParam String name) {
        events.add(new EventModel(name));
        return "redirect:"; // to controller method with URL: "/events"
    }

}
