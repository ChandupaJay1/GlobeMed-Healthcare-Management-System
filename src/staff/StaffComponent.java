/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package staff;

/**
 *
 * @author chand
 */
public interface StaffComponent {
    String getName();
    boolean hasPermission(String permission);
    void add(StaffComponent component);
    void remove(StaffComponent component);
}
