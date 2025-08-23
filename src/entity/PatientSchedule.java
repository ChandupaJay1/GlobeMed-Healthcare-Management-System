/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author chand
 */
public class PatientSchedule {
    private String patientId;
    private String patientName;
    private String patientMobile;
    private String appointedTime;
    private Doctor doctor;
    private String location; // optional for multi-location

    public PatientSchedule(String patientId, String patientName, String patientMobile, String appointedTime, Doctor doctor, String location) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.appointedTime = appointedTime;
        this.doctor = doctor;
        this.location = location;
    }

    public String getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public String getPatientMobile() { return patientMobile; }
    public String getAppointedTime() { return appointedTime; }
    public Doctor getDoctor() { return doctor; }
    public String getLocation() { return location; }
}
