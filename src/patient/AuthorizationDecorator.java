/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patient;

/**
 *
 * @author chand
 */
public class AuthorizationDecorator extends PatientRecordDecorator {
    private String userRole;

    public AuthorizationDecorator(PatientRecord patientRecord, String userRole) {
        super(patientRecord);
        this.userRole = userRole;
    }

    @Override
    public void save(String data) {
        System.out.println("AuthorizationDecorator: Checking save permissions for role: " + userRole);
        if (hasWritePermission()) {
            System.out.println("AuthorizationDecorator: Write permission granted");
            super.save(data);
        } else {
            System.out.println("AuthorizationDecorator: Access denied - insufficient permissions");
            throw new SecurityException("Access denied: " + userRole + " cannot save records");
        }
    }

    @Override
    public String load() {
        System.out.println("AuthorizationDecorator: Checking read permissions for role: " + userRole);
        if (hasReadPermission()) {
            System.out.println("AuthorizationDecorator: Read permission granted");
            return super.load();
        } else {
            System.out.println("AuthorizationDecorator: Access denied - insufficient permissions");
            throw new SecurityException("Access denied: " + userRole + " cannot read records");
        }
    }

    private boolean hasWritePermission() {
        return userRole.equals("Doctor") || userRole.equals("Admin");
    }

    private boolean hasReadPermission() {
        return userRole.equals("Doctor") || userRole.equals("Nurse") || userRole.equals("Admin");
    }
}