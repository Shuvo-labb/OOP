/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private String medication;
    private String dosage;
    private int quantity;

    public Prescription(String prescriptionId, String patientId, String doctorId, String medication, String dosage, int quantity) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medication = medication;
        this.dosage = dosage;
        this.quantity = quantity;
    }

    // Getters
    public String getPrescriptionId() { return prescriptionId; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getMedication() { return medication; }
    public String getDosage() { return dosage; }
    public int getQuantity() { return quantity; }

    // Setters (if needed, though prescriptions are usually final)
    // public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Prescription{" + "prescriptionId=" + prescriptionId + ", patientId=" + patientId + ", doctorId=" + doctorId + ", medication=" + medication + ", dosage=" + dosage + ", quantity=" + quantity + '}';
    }
}
