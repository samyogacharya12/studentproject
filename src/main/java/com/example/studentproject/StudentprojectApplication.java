package com.example.studentproject;

import com.example.studentproject.entity.User;
import com.example.studentproject.entity.security.Role;
import com.example.studentproject.entity.security.UserRole;
import com.example.studentproject.enumconstant.AuthorityType;
import com.example.studentproject.enumconstant.Privilege;
import com.example.studentproject.enumconstant.Status;
import com.example.studentproject.repository.RoleRepository;
import com.example.studentproject.repository.UserRepository;
import com.example.studentproject.utility.SecurityUtility;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class StudentprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentprojectApplication.class, args);
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return SecurityUtility.passwordEncoder();
    }


    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository) {

        return args -> {

            Role superAdminRole = createRole(roleRepository, "ADMIN");
            Role relianceRole = createRole(roleRepository, "USER");


            User user = userRepository.findByEmail("samyog.acharya@gmail.com");
            if (user==null) {
                User superUser = new User();
                superUser.setEmail("samyog.acharya@gmail.com");
                superUser.setMobile("9804334560");
                superUser.setFirstName("Samyog");
                superUser.setLastName("Acharya");
                superUser.setUsername("admin");
                superUser.setPassword(passwordEncoder().encode("admin"));
                superUser.setUserType(AuthorityType.ADMIN);
                Set<UserRole> userRoles = new HashSet<>();
                userRoles.add(new UserRole(superUser, superAdminRole));
                userRoles.add(new UserRole(superUser, relianceRole));
                superUser.setUserRoles(userRoles);
                superUser = userRepository.save(superUser);
            }
        };

    }


    private Role createRole(RoleRepository roleRepository, String name) {
        Role role = roleRepository.findByName(name);
        if (role==null) {

            Set<Privilege> privilegeSet = new HashSet<>();

            privilegeSet.addAll(Arrays.asList(Privilege.values()));

            role = new Role();

            role.setStatus(Status.ACTIVE);
            role.setName(name);
            role.setPermissionSet(privilegeSet);

            return roleRepository.save(role);

        } else if (role.getPermissionSet().size() != Arrays.asList(Privilege.values()).size()) {
            Set<Privilege> privilegeSet = new HashSet<>();

            privilegeSet.addAll(Arrays.asList(Privilege.values()));

            role.setPermissionSet(privilegeSet);

            return roleRepository.save(role);
        }
        return role;
    }


}
