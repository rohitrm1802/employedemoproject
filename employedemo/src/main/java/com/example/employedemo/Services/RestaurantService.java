package com.example.employedemo.Services;

import com.example.employedemo.Entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant SaveFood(Restaurant rest);

    public Restaurant GetByOrderId(Long id);

    public List<Restaurant> GetAllOrder();

    public String DeleteOrderById(Long Id);

    public Restaurant UpdateRestaurant(Long id,Restaurant rst);
}
