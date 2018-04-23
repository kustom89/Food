package com.example.andre.food.data;

import com.example.andre.food.models.Food;

import java.util.ArrayList;
import java.util.List;

public class Queries {

    public List<Food> foods(){
        List<Food> foods= new ArrayList<>();
        List<Food> foodList= Food.find(Food.class, "done=0");
        if (foodList!=null&& foodList.size()>0){
            foods.addAll(foodList);
        }
        return foods;
    }

}
