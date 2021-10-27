package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import com.example.demo.entities.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByEmail(String Email);
    Boolean existsByEmail(String email);

    @Query("SELECT em FROM Employee em WHERE em.employment.name=?1")
    List<Employee>queryFiltrarPorNombre(String name);
}



