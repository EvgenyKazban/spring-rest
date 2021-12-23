package spring.rest.initDbUsers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.rest.entities.Role;
import spring.rest.entities.User;
import spring.rest.service.RoleService;
import spring.rest.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitDBUsers {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitDBUsers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initApiUserData() {

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        Set<Role> rolesForAdmin = new HashSet<>();
        Set<Role> rolesForUser = new HashSet<>();

        rolesForAdmin.add(roleService.findRoleById(1L));
        rolesForAdmin.add(roleService.findRoleById(2L));

        rolesForUser.add(roleService.findRoleById(2L));

        User user1 = new User("Ivan","Ivanov","IIIIII","admin@admin.ad");
        user1.setRoles(rolesForAdmin);

        User user2 = new User("Oksana","Ivanova","OOOOOO",
                "root@root.ro");

        user2.setRoles(rolesForUser);

        userService.addUser(user1);
        userService.addUser(user2);

    }
}
