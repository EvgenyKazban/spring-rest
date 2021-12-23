package spring.rest.service;

import spring.rest.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> allRole();
    Role findRoleById(Long id);
    void addRole(Role role);
}
