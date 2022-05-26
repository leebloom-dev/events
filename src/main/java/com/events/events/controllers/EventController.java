package com.events.events.controllers;

import javax.validation.Valid;

import com.events.events.data.EventData;
import com.events.events.models.EventModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("events") // URL: localhost:8080/events
public class EventController {
    
    // responds to GET requests at URL "/events"
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "Events Home Page");
        model.addAttribute("events", EventData.getAll());
        return "/events/index";
    }

    // responds to GET requests at URL "/events/form"
    @GetMapping("form")
    public String displayEventForm(Model model) {
        model.addAttribute("title", "Event Form");
        return "/events/form";
    }

    // responds to POST requests at URL "/events/form"
    @PostMapping("form")
    public String processEventForm(@ModelAttribute @Valid EventModel newEvent, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Event Form");
            model.addAttribute("errorMsgName", "Name must be between 3 and 50 characters.");
            model.addAttribute("errorMsgDescription", "Description too long.");
            model.addAttribute("errorMsgContactEmail", "Invalid Email. Try again.");
            return "/events/form";
        }

        EventData.add(newEvent);
        return "redirect:"; // to controller method with URL: "/events"
    }

    // responds to GET requests at URL "/events/delete"
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "/events/delete";
    }

    // responds to POST requests at URL "/events/delete"
    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam int[] eventIds) {
        for (int event : eventIds) {
            EventData.remove(event);
        }
        return "redirect:";
    }

}
