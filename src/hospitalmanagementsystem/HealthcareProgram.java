/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: HealthcareProgram.java
package hospitalmanagementsystem;

/**
 * Represents a healthcare program offered by the hospital.
 * Demonstrates Encapsulation (CLO1, CLO3).
 */
public class HealthcareProgram {
    private String programId;
    private String name;
    private String description;
    private String schedule; // Could be more structured, but keeping it simple for now

    public HealthcareProgram(String programId, String name, String description, String schedule) {
        this.programId = programId;
        this.name = name;
        this.description = description;
        this.schedule = schedule;
    }

    // Getters
    public String getProgramId() { return programId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getSchedule() { return schedule; }

    // Setters (for admin to manage programs)
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setSchedule(String schedule) { this.schedule = schedule; }

    @Override
    public String toString() {
        return "HealthcareProgram{" + "programId=" + programId + ", name=" + name + ", description=" + description + ", schedule=" + schedule + '}';
    }
}
