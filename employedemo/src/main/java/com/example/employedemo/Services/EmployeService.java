package com.example.employedemo.Services;

import com.example.employedemo.CustomException.EmployeException;
import com.example.employedemo.Entity.Employe;

import java.util.List;

public interface EmployeService {

    public Employe SaveEmploye(Employe emp) throws EmployeException;

    public Employe GetById(Long id) throws EmployeException;

    public List<Employe> GetAll();

    public String DeleteById(Long id);

    public Employe UpdateDetails(Long id, Employe e);
}
