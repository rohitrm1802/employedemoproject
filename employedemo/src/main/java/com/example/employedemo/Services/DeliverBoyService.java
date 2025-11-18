package com.example.employedemo.Services;

import com.example.employedemo.Entity.FoodDelBoy;

import java.util.List;

public interface DeliverBoyService {

    public FoodDelBoy SaveFood(FoodDelBoy fd);

    public FoodDelBoy GetById(Long id);

    public List<FoodDelBoy> GetAll();

    public String DeleteById(Long id);

    public FoodDelBoy UpdateFood(Long id,FoodDelBoy fd);
}
