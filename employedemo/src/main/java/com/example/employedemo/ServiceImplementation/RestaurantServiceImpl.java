package com.example.employedemo.ServiceImplementation;

import com.example.employedemo.Entity.Restaurant;
import com.example.employedemo.Repository.RestaurantRepository;
import com.example.employedemo.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository rest;

    @Override
    public Restaurant SaveFood(Restaurant res)
    {
        return rest.save(res);
    }
    @Override
    public Restaurant GetByOrderId(Long id)
    {
        return rest.findById(id).orElseThrow(()-> new RuntimeException("Hi Rohit - Order id not found"));
    }
    @Override
    public List<Restaurant> GetAllOrder()
    {
        return rest.findAll();
    }

    @Override
    public String DeleteOrderById(@PathVariable Long Id)
    {
         rest.deleteById(Id);

         return "Id Deleted Successfully";
    }

    @Override
    public Restaurant UpdateRestaurant(Long id,Restaurant rst)
    {
        Restaurant rs = rest.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));

        rs.setCustomname(rst.getCustomname());
        rs.setMobnum(rst.getMobnum());

        return rest.save(rs);
    }
}
