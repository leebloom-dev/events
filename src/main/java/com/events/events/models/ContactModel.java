package com.events.events.models;

import javax.annotation.Generated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ContactModel {

    private int id;
    private static int nextId = 1;

    @NotBlank
    @Size(min = 3, max = 50, message = "First name must be between 3 an 50 characters.")
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 50, message = "First name must be between 3 an 50 characters.")
    private String lastName;
    @NotBlank
    @Email(message = "Invalid email, try again.")
    private String email;

    public ContactModel(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public ContactModel() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
