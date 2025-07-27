/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: Policy.java
package hospitalmanagementsystem;

/**
 * Represents a hospital policy.
 * Demonstrates Encapsulation (CLO1, CLO3).
 */
public class Policy {
    private String policyId;
    private String title;
    private String description;

    public Policy(String policyId, String title, String description) {
        this.policyId = policyId;
        this.title = title;
        this.description = description;
    }

    // Getters
    public String getPolicyId() { return policyId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }

    // Setters (for admin to update policies)
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Policy{" + "policyId=" + policyId + ", title=" + title + ", description=" + description + '}';
    }
}
