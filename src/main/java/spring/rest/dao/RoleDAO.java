package spring.rest.dao;

import spring.rest.entities.Role;


import java.util.List;

public interface RoleDAO {

    List<Role> allRole();
    Role findRoleById(Long id);
    void addRole(Role role);
}
