package com.example.studentproject.service;

import com.example.studentproject.entity.User;
import com.example.studentproject.entity.security.Authority;
import com.example.studentproject.entity.security.Role;
import com.example.studentproject.entity.security.UserRole;
import com.example.studentproject.repository.RoleRepository;
import com.example.studentproject.repository.UserRepository;
import com.example.studentproject.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private RoleRepository roleRepository;

    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return SecurityUtility.passwordEncoder();
    }

    public User findUserByEmail(String email) {
        return userService.findByEmail(email);
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        Role role = roleRepository.findByName("ADMIN");

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, role));
        user.setUserRoles(userRoles);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByUserName(username);
        if (Objects.nonNull(user)) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getUserRoles());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<UserRole> userRoles) {

        List<GrantedAuthority> authorites = new ArrayList<>();
        userRoles.forEach(ur -> authorites.add(new Authority(ur.getRole().getName())));

        return authorites;

    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getMobile(), user.getPassword(), authorities);
    }
}
