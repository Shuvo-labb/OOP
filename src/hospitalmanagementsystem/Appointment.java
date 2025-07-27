/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: Appointment.java
package hospitalmanagementsystem;

/**
 * Represents an appointment between a patient and a doctor.
 * Demonstrates Encapsulation (CLO1, CLO3).
 */
public class Appointment {
    private String appointmentId;
    private String patientId; // Links to Patient
    private String doctorId;  // Links to Doctor
    private String date;      // Consider using java.time.LocalDate for better date handling
    private String time;      // Consider using java.time.LocalTime
    private String status;    // e.g., Pending, Confirmed, Cancelled

    public Appointment(String appointmentId, String patientId, String doctorId, String date, String time, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    // Getters
    public String getAppointmentId() { return appointmentId; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }

    // Setters (especially useful for updating status)
    public void setStatus(String status) { this.status = status; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        return "Appointment{" + "appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId + ", date=" + date + ", time=" + time + ", status=" + status + '}';
    }
}
