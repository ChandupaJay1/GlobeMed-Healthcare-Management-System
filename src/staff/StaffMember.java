/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff;

import java.util.Set;

/**
 *
 * @author chand
 */
public class StaffMember implements StaffComponent {
    private String name;
    private Set<String> permissions;

    public StaffMember(String name, Set<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }

    @Override
    public void add(StaffComponent component) {
        throw new UnsupportedOperationException("Cannot add to a leaf component");
    }

    @Override
    public void remove(StaffComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf component");
    }
}
