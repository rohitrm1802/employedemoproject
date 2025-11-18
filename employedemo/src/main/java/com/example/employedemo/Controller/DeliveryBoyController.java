package com.example.employedemo.Controller;

import com.example.employedemo.Entity.FoodDelBoy;
import com.example.employedemo.Services.DeliverBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boy")
public class DeliveryBoyController {

    @Autowired
    DeliverBoyService dbs;

    @PostMapping
    public ResponseEntity<FoodDelBoy> SaveFood(@RequestBody FoodDelBoy db)
    {
        FoodDelBoy fd = dbs.SaveFood(db);

        return ResponseEntity.status(HttpStatus.CREATED).body(fd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDelBoy> FindById(@PathVariable Long id)
    {
        FoodDelBoy fd = dbs.GetById(id);

        return ResponseEntity.ok(fd);
    }

    @GetMapping("/showall")
    public ResponseEntity<List<FoodDelBoy>> FindAll()
    {
        List<FoodDelBoy> fd = dbs.GetAll();

        return ResponseEntity.ok(fd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteById(@PathVariable Long id)
    {
        String s = dbs.DeleteById(id);

        return ResponseEntity.ok(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodDelBoy> UpdateFood(@PathVariable Long id,@RequestBody FoodDelBoy fdb)
    {
        FoodDelBoy fd = dbs.UpdateFood(id,fdb);

        return ResponseEntity.ok(fd);
    }
}
