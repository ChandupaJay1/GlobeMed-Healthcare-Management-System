/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patient;

import patient.PatientRecord;
import patient.PatientRecordDecorator;

/**
 *
 * @author chand
 */
public class LoggingDecorator extends PatientRecordDecorator {
    
    public LoggingDecorator(PatientRecord patientRecord) {
        super(patientRecord);
    }

    @Override
    public void save(String data) {
        System.out.println("LoggingDecorator: Logging save operation...");
        super.save(data);
        System.out.println("LoggingDecorator: Save operation logged successfully");
    }

    @Override
    public String load() {
        System.out.println("LoggingDecorator: Logging load operation...");
        String result = super.load();
        System.out.println("LoggingDecorator: Load operation logged successfully");
        return result;
    }
}