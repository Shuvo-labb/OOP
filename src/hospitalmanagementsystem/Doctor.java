/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: Doctor.java
package hospitalmanagementsystem;

import javax.swing.*;
import java.util.List;

/**
 * Represents a Doctor in the Hospital Management System.
 * Extends User class and implements doctor-specific functionalities.
 * 
 * CLO1: Demonstrates Inheritance and Encapsulation
 * CLO3: Implements real-world doctor role
 */
// File: Doctor.java


public class Doctor extends User {
    private String doctorId;
    private String id;        // For file data
    private String name;
    private String specialization;
    private String contact;

    // Constructor for login
    public Doctor(String username, String password, String doctorId) {
        super(username, password, "Doctor");
        this.doctorId = doctorId;
    }

    // Constructor for loading from doctors.txt
    public Doctor(String id, String name, String specialization, String contact) {
        super("temp", "temp", "Doctor");
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.contact = contact;
    }

    @Override
    public void showDashboard() {
        new DoctorDashboard(doctorId).setVisible(true);
    }

    public String getDoctorId() {
        return doctorId != null ? doctorId : id;
    }
}