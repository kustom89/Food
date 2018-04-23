package com.example.andre.food.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.andre.food.R;
import com.example.andre.food.models.Food;

public class DetailsActivity extends AppCompatActivity {

    private static final String FOOD_ID = "com.example.andre.food.KEY.FOOD_ID";
    private TextView name;
    private TextView type;

    private Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long FoodId= getIntent().getLongExtra(FOOD_ID,0);
        food=Food.findById(Food.class, FoodId);
        name=findViewById(R.id.detailnameTv);
        type=findViewById(R.id.detailTypeTv);

        name.setText(food.getName());
        type.setText(food.getType());



    }
}
