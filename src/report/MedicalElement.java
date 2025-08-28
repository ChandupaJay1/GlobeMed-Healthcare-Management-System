/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

/**
 *
 * @author chand
 */
public interface MedicalElement {

    void accept(ReportVisitor visitor);
}

class Patient implements MedicalElement {

    private String name;
    private String diagnosis;

    public Patient(String name, String diagnosis) {
        this.name = name;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visit(this);
    }
}

class Doctor implements MedicalElement {

    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visit(this);
    }
}

class Billing implements MedicalElement {

    private double amount;

    public Billing(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visit(this);
    }
}
