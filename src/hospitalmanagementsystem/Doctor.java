/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: Doctor.java
package hospitalmanagementsystem;

/**
 * Represents a doctor in the hospital.
 * Demonstrates Encapsulation (CLO1, CLO3).
 */
public class Doctor {
    private String id;
    private String name;
    private String specialization;
    private String contact;

    public Doctor(String id, String name, String specialization, String contact) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.contact = contact;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getContact() { return contact; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public void setContact(String contact) { this.contact = contact; }

    @Override
    public String toString() {
         return "Doctor{" + "id=" + id + ", name=" + name + ", specialization=" + specialization + ", contact=" + contact + '}';
    }
}
