package com.events.events.controllers;

import javax.validation.Valid;

import com.events.events.data.ContactData;
import com.events.events.models.ContactModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("contacts") // URL: localhost:8080/contacts
public class ContactsController {
    
    // responds to GET requests at URL "/contacts"
    @GetMapping
    public String displayAllContacts(Model model) {
        model.addAttribute("title", "Contacts Home Page");
        model.addAttribute("contacts", ContactData.getAll());
        return "/contacts/index"; // html path
    }

    // responds to GET requests at URL "/contacts/form"
    @GetMapping("form")
    public String displayEventForm(Model model) {
        model.addAttribute("title", "Contact Form");
        return "/contacts/form";
    }

    // responds to POST requests at URL "/contacts/form"
    @PostMapping("form")
    public String processContactForm(@ModelAttribute @Valid ContactModel newContact,
                                     Errors errors,
                                     Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Contact Form");
            model.addAttribute("errorMsgFirstName", "First name must be between 3 an 50 characters.");
            model.addAttribute("errorMsgLastName", "First name must be between 3 an 50 characters.");
            model.addAttribute("errorMsgEmail", "Invalid email, try again.");
            return "/contacts/form";
        }
        
        ContactData.add(newContact);

        return "redirect:"; // to URL "/contacts"
    }

    // responds to GET requests at URL "/contacts/remove"
    @GetMapping("remove")
    public String displayRemoveForm(Model model) {
        model.addAttribute("title", "Remove Contact");
        model.addAttribute("contacts", ContactData.getAll());
        return "/contacts/remove";
    }

    // responds to POST requests at URL "/contacts/remove"
    @PostMapping("remove")
    public String processRemoveForm(@RequestParam int[] contactIds) {
        for (int contactId : contactIds) {
            ContactData.remove(contactId);
        }
        return "redirect:";
    }

}
