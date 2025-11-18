package com.example.employedemo.Controller;

import com.example.employedemo.Entity.Restaurant;
import com.example.employedemo.Services.RestaurantService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resta")
public class RestaurantController {

    @Autowired
    RestaurantService rest;

    @PostMapping
    public ResponseEntity<Restaurant> savefood(@RequestBody Restaurant res)
    {
        Restaurant rt = rest.SaveFood(res);

        return ResponseEntity.ok(rt);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getbyid(@PathVariable Long id)
    {
        Restaurant rt = rest.GetByOrderId(id);

        return ResponseEntity.ok(rt);
    }

    @GetMapping("/getAllOrder")
    public ResponseEntity<List<Restaurant>> GetByOrder()
    {
        List<Restaurant> rt = rest.GetAllOrder();

        return ResponseEntity.ok(rt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteId(@PathVariable Long id)
    {
        String s = rest.DeleteOrderById(id);

        return ResponseEntity.accepted().body(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> UpdateRestaurant(@PathVariable Long id,@RequestBody Restaurant rst)
    {
        Restaurant rt = rest.UpdateRestaurant(id,rst);

        return ResponseEntity.ok(rt);
    }
}
