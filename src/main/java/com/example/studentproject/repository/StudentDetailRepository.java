package com.example.studentproject.repository;

import com.example.studentproject.entity.StudentDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface StudentDetailRepository extends JpaRepository<StudentDetail, Long> {


    @Query("select s from StudentDetail  s where s.id is not null")
    Page<StudentDetail> findAll(Pageable pageable);


}
