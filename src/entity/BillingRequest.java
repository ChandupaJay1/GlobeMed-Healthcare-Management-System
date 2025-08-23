/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author chand
 */
public class BillingRequest {
    private String patientId;
    private String patientName;
    private List<String> services; // e.g., "Consultation", "Treatment", "Medication"
    private boolean hasInsurance;
    private double totalAmount;

    public BillingRequest(String patientId, String patientName, List<String> services, boolean hasInsurance) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.services = services;
        this.hasInsurance = hasInsurance;
        this.totalAmount = 0.0;
    }

    // Getters and setters
    public String getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public List<String> getServices() { return services; }
    public boolean hasInsurance() { return hasInsurance; }
    public double getTotalAmount() { return totalAmount; }
    public void addAmount(double amount) { this.totalAmount += amount; }
}