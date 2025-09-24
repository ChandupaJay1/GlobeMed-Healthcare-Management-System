/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patient;

/**
 *
 * @author chand
 */
abstract class PatientRecordDecorator implements PatientRecord {
    protected PatientRecord wrappedRecord;

    public PatientRecordDecorator(PatientRecord patientRecord) {
        this.wrappedRecord = patientRecord;
    }

    @Override
    public void save(String data) {
        wrappedRecord.save(data);
    }

    @Override
    public String load() {
        return wrappedRecord.load();
    }
}
