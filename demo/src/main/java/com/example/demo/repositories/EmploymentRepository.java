package com.example.demo.repositories;

import com.example.demo.entities.Employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmploymentRepository extends JpaRepository<Employment,Long> {
}
