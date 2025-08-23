/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appoinment;

import entity.Doctor;
import entity.PatientSchedule;
import java.util.ArrayList;


/**
 *
 * @author chand
 */
public class AppoinmentMediatorImpl implements AppoinmentMediator{
    
     private Doctor selectedDoctor;
    private ArrayList<PatientSchedule> schedules = new ArrayList<>();

    @Override
    public void selectDoctor(Doctor doctor) {
        this.selectedDoctor = doctor;
        System.out.println("Mediator: Doctor selected -> " + doctor.getName());
    }

    @Override
    public boolean schedulePatient(PatientSchedule schedule) {
        // Check for conflict: same doctor, same time
        for (PatientSchedule ps : schedules) {
            if (ps.getDoctor().equals(schedule.getDoctor()) && ps.getAppointedTime().equals(schedule.getAppointedTime())) {
                System.out.println("⚠ Conflict detected: " + schedule.getDoctor().getName() + " at " + schedule.getAppointedTime());
                return false; // cannot schedule
            }
        }

        schedules.add(schedule);
        System.out.println("✅ Appointment scheduled for " + schedule.getPatientName() + " with " + schedule.getDoctor().getName());
        return true;
    }

    public Doctor getSelectedDoctor() {
        return selectedDoctor;
    }

    public ArrayList<PatientSchedule> getSchedules() {
        return schedules;
    }
    
}
