package com.example.employedemo.ServiceImplementation;

import com.example.employedemo.CustomException.EmployeException;
import com.example.employedemo.Entity.Employe;
import com.example.employedemo.Repository.EmployeRepository;
import com.example.employedemo.Services.EmployeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeServiceImpl.class);

    @Autowired
    EmployeRepository em;

    @Override
    public Employe SaveEmploye(Employe emp)
    {
        try
        {
            log.info("Entering in save employee method ");
            if(emp.getAddress() == null)
            {
                log.info("Enter the name correct not be null");
                throw new EmployeException("Name may not be null");
            }
            return em.save(emp);
        }
//        catch(EmployeException e)
//        {
//            throw new EmployeException(e.getMessage());
//        }
//        catch(RuntimeException e)
//        {
//            if (e instanceof EmployeException)
//                {
//                    throw (EmployeException) e;  // it’s mine, so just rethrow
//                }
////            throw new EmployeException("Enter Correct Fields");
//
//            throw new EmployeException("Error While Saving The EmployeeDetails");
//        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Employe GetById(Long id)
    {
        log.info("Entering The Employee GetById Method");
        return em.findById(id).orElseThrow(()-> new EmployeException("Employee ID not found"));

        //failed to get employe
    }

    @Override
    public List<Employe> GetAll()
    {
        try
        {
            return em.findAll();
        }
        catch(RuntimeException e)
        {
            throw new EmployeException("Error while showing the employee");
        }
    }

    @Override
    public String DeleteById(Long id)
    {
        try
        {
            em.deleteById(id);
            return "Employee Id Successfully Deleted";
        }
        catch (EmployeException e)
        {
            throw new EmployeException("Id Not Found");
        }
    }

    @Override
    public Employe UpdateDetails(Long id, Employe e)
    {
        try
        {
            Employe empupdate = em.findById(id).orElseThrow(()-> new RuntimeException("Employee Id Not Found"));

            empupdate.setAddress(e.getAddress());
            empupdate.setName(e.getName());

            return em.save(empupdate);
        }
        catch (EmployeException ex)
        {
            throw new EmployeException("Enter Correct Details");
        }
    }
}
