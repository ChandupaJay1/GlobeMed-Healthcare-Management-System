/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chand
 */
public class StaffGroup implements StaffComponent{
    
        private String name;
    private List<StaffComponent> staffList = new ArrayList<>();

    public StaffGroup(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean hasPermission(String permission) {
        
        for (StaffComponent staff : staffList) {
            if (staff.hasPermission(permission)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(StaffComponent component) {
        staffList.add(component);
    }

    @Override
    public void remove(StaffComponent component) {
        staffList.remove(component);
    }
    
}
