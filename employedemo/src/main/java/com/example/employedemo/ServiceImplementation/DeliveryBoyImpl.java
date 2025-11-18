package com.example.employedemo.ServiceImplementation;

import com.example.employedemo.Entity.FoodDelBoy;
import com.example.employedemo.Repository.DeliveryBoyRepository;
import com.example.employedemo.Services.DeliverBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryBoyImpl implements DeliverBoyService{

    @Autowired
    DeliveryBoyRepository deliveryrepo;

    @Override
    public FoodDelBoy SaveFood(FoodDelBoy fd)
    {
        return deliveryrepo.save(fd);
    }

    @Override
    public FoodDelBoy GetById(Long id)
    {
        return deliveryrepo.findById(id).orElseThrow(()-> new RuntimeException("ID not found"));
    }

    @Override
    public List<FoodDelBoy> GetAll()
    {
        return deliveryrepo.findAll();
    }

    @Override
    public String DeleteById(Long id)
    {
        deliveryrepo.deleteById(id);
        return "Id Deleted Successfully";
    }

    @Override
    public FoodDelBoy UpdateFood(Long id, FoodDelBoy fd)
    {
        FoodDelBoy fdb = deliveryrepo.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));

        fdb.setName(fd.getName());
        fdb.setPhonenum(fd.getPhonenum());

        return deliveryrepo.save(fdb);
    }
}


















