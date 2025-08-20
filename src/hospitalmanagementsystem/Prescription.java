/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: Prescription.java
// File: Prescription.java
package hospitalmanagementsystem;

/**
 * Represents a prescription given by a doctor to a patient.
 * Demonstrates Encapsulation (CLO1, CLO3).
 */
public class Prescription {
    private String prescriptionId;
    private String patientId;  // Links to Patient
    private String doctorId;   // Links to Doctor
    private String medicineName;
    private String dosage;
    private String date;       // Added: date field

    // Constructor with all fields
    public Prescription(String prescriptionId, String patientId, String doctorId, String medicineName, String dosage, String date) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.date = date;
    }

    // Getters
    public String getPrescriptionId() { return prescriptionId; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getMedicineName() { return medicineName; }
    public String getDosage() { return dosage; }
    public String getDate() { return date; }

    // Setters (optional)
    public void setDosage(String dosage) { this.dosage = dosage; }
    public void setDate(String date) { this.date = date; }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId='" + prescriptionId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}