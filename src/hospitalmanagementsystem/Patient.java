/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: Patient.java
// File: Patient.java
// File: Patient.java
/*
 * File: Patient.java
 * Purpose: Represents a patient in the Hospital Management System
 * Implements CLO1 (OOP Concepts) and CLO3 (System Functionality)
 */
package hospitalmanagementsystem;

import javax.swing.*;

/**
 * Represents a patient in the hospital.
 * Demonstrates Encapsulation and Inheritance (CLO1, CLO3).
 */
public class Patient extends User {
    // Patient-specific data
    private String id;
    private String name;
    private int age;
    private String gender;
    private String medicalHistory;
    private String region;
    private String patientId; // For login and dashboard access

    /**
     * Constructor for loading patient data from patients.txt
     * Format: ID, Name, Age, Gender, MedicalHistory, Region
     */
    public Patient(String id, String name, int age, String gender, String medicalHistory, String region) {
        super("temp", "temp", "Patient"); // Temporary values
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
        this.region = region;
    }

    /**
     * Constructor for login authentication
     * @param username Login username
     * @param password Login password
     * @param patientId Unique ID (e.g., P001)
     */
    public Patient(String username, String password, String patientId) {
        super(username, password, "Patient");
        this.patientId = patientId;
    }

    /**
     * Override showDashboard() to open PatientDashboard
     */
    @Override
    public void showDashboard() {
        new PatientDashboard(patientId).setVisible(true);
    }

    // ————————————————————————
    // GETTERS
    // ————————————————————————

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getMedicalHistory() { return medicalHistory; }
    public String getRegion() { return region; }
    public String getPatientId() { return patientId; }

    // ————————————————————————
    // SETTERS
    // ————————————————————————

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }
    public void setRegion(String region) { this.region = region; }

    /**
     * Override toString for easy display
     */
    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", region='" + region + '\'' +
                ", patientId='" + patientId + '\'' +
                '}';
    }
}