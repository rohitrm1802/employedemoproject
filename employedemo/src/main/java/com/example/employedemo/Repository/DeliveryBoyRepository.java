package com.example.employedemo.Repository;

import com.example.employedemo.Entity.FoodDelBoy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryBoyRepository extends JpaRepository<FoodDelBoy,Long> {

}
