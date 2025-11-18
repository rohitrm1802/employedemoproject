package com.example.employedemo.Repository;

import com.example.employedemo.Entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
