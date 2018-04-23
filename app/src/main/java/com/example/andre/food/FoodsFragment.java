package com.example.andre.food;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.andre.food.adapters.FoodClickListener;
import com.example.andre.food.adapters.FoodsAdapter;
import com.example.andre.food.details.DetailsActivity;
import com.example.andre.food.models.Food;

/**
 * A placeholder fragment containing a simple view.
 */
public class FoodsFragment extends Fragment implements FoodClickListener {

    private static final String FOOD_ID = "com.example.andre.food.KEY.FOOD_ID";
    private FoodsAdapter adapter;

    public FoodsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView= view.findViewById(R.id.foodRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        adapter= new FoodsAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    public void updateList(Food food){
        adapter.update(food);

        Log.d("Food",food.getName() );

    }

    @Override//mostrar la posicion presionando el textView
    public void ClickedID(long id) {
        Toast.makeText(getContext(),String.valueOf(id), Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(getContext(), DetailsActivity.class);
        intent.putExtra(FOOD_ID, id);
        startActivity(intent);

    }
}
