/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billing;

import entity.BillingRequest;

/**
 *
 * @author chand
 */
public abstract class BillingHandler {

    protected BillingHandler nextHandler;

    public void setNextHandler(BillingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void process(BillingRequest request);
}

class VaccinationsBillingHandler extends BillingHandler {

    @Override
    public void process(BillingRequest request) {
        if (request.getServices().contains("Vaccinations")) {
            request.addAmount(50.0); // example charge
            System.out.println("Consultation charge added: $50");
        }
        if (nextHandler != null) {
            nextHandler.process(request);
        }
    }
}

class LaboratoryTestsBillingHandler extends BillingHandler {

    @Override
    public void process(BillingRequest request) {
        if (request.getServices().contains("Laboratory Tests")) {
            request.addAmount(100.0); // example charge
            System.out.println("Treatment charge added: $100");
        }
        if (nextHandler != null) {
            nextHandler.process(request);
        }
    }
}

class PhysiotherapyBillingHandler extends BillingHandler {

    @Override
    public void process(BillingRequest request) {
        if (request.getServices().contains("Physiotherapy")) {
            request.addAmount(30.0); // example charge
            System.out.println("Medication charge added: $30");
        }
        if (nextHandler != null) {
            nextHandler.process(request);
        }
    }
}

class InsuranceClaimHandler extends BillingHandler {

    @Override
    public void process(BillingRequest request) {
        if (request.hasInsurance()) {
            System.out.println("Insurance claim process done for patient: " + request.getPatientName());
            request.addAmount(-request.getTotalAmount() * 0.5); // 
        }
        if (nextHandler != null) {
            nextHandler.process(request);
        }
    }
}
