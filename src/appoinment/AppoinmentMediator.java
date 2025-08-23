/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package appoinment;

import entity.Doctor;
import entity.PatientSchedule;

/**
 *
 * @author chand
 */
public interface AppoinmentMediator {

    void selectDoctor(Doctor doctor);

    boolean schedulePatient(PatientSchedule patientSchedule);
}
