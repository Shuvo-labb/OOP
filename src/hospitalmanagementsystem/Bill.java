/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: Bill.java
package hospitalmanagementsystem;

/**
 * Represents a bill for a patient.
 * Demonstrates Encapsulation (CLO1, CLO3).
 */
public class Bill {
    private String billId;
    private String patientId; // Links to Patient
    private double amount;
    private String status;    // e.g., Paid, Unpaid, Overdue

    public Bill(String billId, String patientId, double amount, String status) {
        this.billId = billId;
        this.patientId = patientId;
        this.amount = amount;
        this.status = status;
    }

    // Getters
    public String getBillId() { return billId; }
    public String getPatientId() { return patientId; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }

    // Setters (especially for updating status after payment)
    public void setStatus(String status) { this.status = status; }
    public void setAmount(double amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "Bill{" + "billId=" + billId + ", patientId=" + patientId + ", amount=" + amount + ", status=" + status + '}';
    }
}
