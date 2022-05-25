package com.events.events.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.events.events.models.ContactModel;

public class ContactData {

    private static Map<Integer, ContactModel> contacts = new HashMap<>();

    public static Collection<ContactModel> getAll() {
        return contacts.values();
    }

    public static ContactModel getById(int id) {
        return contacts.get(id);
    }

    public static void add(ContactModel contact) {
        contacts.put(contact.getId(), contact);
    }

    public static void remove(int id) {
        contacts.remove(id);
    }
    
}
