/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patient;

import java.util.Base64;

/**
 *
 * @author chand
 */
public interface PatientRecord {

    void save(String data);

    String load();
}
