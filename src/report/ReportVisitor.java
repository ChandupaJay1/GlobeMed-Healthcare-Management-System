/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

/**
 *
 * @author chand
 */
public interface ReportVisitor {

    void visit(Patient patient);

    void visit(Doctor doctor);

    void visit(Billing billing);
}

class TreatmentReportVisitor implements ReportVisitor {

    @Override
    public void visit(Patient patient) {
        System.out.println("Generating treatment summary for patient: " + patient.getName());
        // extract treatments
    }

    @Override
    public void visit(Doctor doctor) {
        System.out.println("Including doctor details: " + doctor.getName());
    }

    @Override
    public void visit(Billing billing) {
        // not needed for treatment report, can leave empty or log
    }
}

class FinancialReportVisitor implements ReportVisitor {

    @Override
    public void visit(Patient patient) {
        System.out.println("Calculating billing details for patient: " + patient.getName());
    }

    @Override
    public void visit(Doctor doctor) {
        // maybe include doctor fees
        System.out.println("Doctor fees included for: " + doctor.getName());
    }

    @Override
    public void visit(Billing billing) {
        System.out.println("Processing billing record: " + billing.getAmount());
    }
}
