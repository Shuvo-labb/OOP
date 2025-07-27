/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: Patient.java
// File: Patient.java
package hospitalmanagementsystem;

/**
 * Represents a patient in the hospital.
 * Demonstrates Encapsulation (CLO1, CLO3).
 */
public class Patient {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String medicalHistory;

    public Patient(String id, String name, int age, String gender, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getMedicalHistory() { return medicalHistory; }

    // Setters (for updating patient info)
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

    @Override
    public String toString() {
        // Useful for displaying patient info easily
        return "Patient{" + "id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", medicalHistory=" + medicalHistory + '}';
    }
}