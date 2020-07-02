package com.example.studentproject.repository;

import com.example.studentproject.entity.Marksheet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MarkSheetRepository extends JpaRepository<Marksheet, Long> {

    @Query("select m from Marksheet m where m.id is not null ")
    Page<Marksheet> findAll(Pageable pageable);


}
