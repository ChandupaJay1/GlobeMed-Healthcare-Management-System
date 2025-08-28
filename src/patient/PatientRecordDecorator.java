/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patient;

/**
 *
 * @author chand
 */
public abstract class PatientRecordDecorator implements PatientRecord {
    protected PatientRecord patientRecord;

    public PatientRecordDecorator(PatientRecord patientRecord) {
        this.patientRecord = patientRecord;
    }

    @Override
    public void save(String data) {
        patientRecord.save(data);
    }

    @Override
    public String load() {
        return patientRecord.load();
    }
}
