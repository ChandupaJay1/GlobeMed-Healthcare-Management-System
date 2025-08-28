/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patient;

import patient.PatientRecord;

/**
 *
 * @author chand
 */
public class BasicPatientRecord implements PatientRecord {
    private String patientName;
    private String data;

    public BasicPatientRecord(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public void save(String data) {
        this.data = data;
        System.out.println("BasicPatientRecord: Saving data for patient " + patientName);
    }

    @Override
    public String load() {
        System.out.println("BasicPatientRecord: Loading data for patient " + patientName);
        return data != null ? data : "No data found";
    }
}

