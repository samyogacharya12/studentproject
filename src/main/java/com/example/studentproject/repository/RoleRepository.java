package com.example.studentproject.repository;

import com.example.studentproject.entity.security.Role;
import com.example.studentproject.enumconstant.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Query("select r from Role r where r.status=?1")
    List<Role> findAllByStatus(Status status);


}
