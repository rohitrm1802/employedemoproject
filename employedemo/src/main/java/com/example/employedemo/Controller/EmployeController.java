package com.example.employedemo.Controller;
import com.example.employedemo.CustomException.EmployeException;
import com.example.employedemo.Entity.Employe;
import com.example.employedemo.Services.EmployeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeController {

    private static final Logger lg = LoggerFactory.getLogger(EmployeController.class);

    @Autowired
    EmployeService emps;

    @PostMapping
    public ResponseEntity<?> SaveDetails(@RequestBody Employe emp)
    {
        try
        {
//            Employe e = new Employe();
//                    e.setName(name);
//                    e.setAddress(address);
            Employe ex = emps.SaveEmploye(emp);

            return ResponseEntity.status(HttpStatus.CREATED).body(ex);
        }
        catch (EmployeException e)
        {
            lg.warn(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        catch (RuntimeException e)
        {
            lg.warn("Hi");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> FindEmploye(@PathVariable Long id)
    {
       try
       {
           Employe e = emps.GetById(id);

           return ResponseEntity.ok(e);
       }
       catch(Exception e)
       {
           lg.warn("Here's the Exception of employee exception");
           return ResponseEntity.ok(e.getMessage());
       }
    }

    @GetMapping("/showall")
    public ResponseEntity<?> ShowAllEmploye()
    {
        try
        {
            lg.info("Entered ShowAll Method");
            List<Employe> e = emps.GetAll();

            return ResponseEntity.accepted().body(e);
        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteEmploye(@PathVariable Long id)
    {
        try
        {
            String e = emps.DeleteById(id);

            return ResponseEntity.ok(e);
        }
        catch (EmployeException e)
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateEmploye(@PathVariable Long id,@RequestBody Employe emp)
    {
        try
        {
            Employe d = emps.UpdateDetails(id,emp);

            return ResponseEntity.ok(d);
        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
