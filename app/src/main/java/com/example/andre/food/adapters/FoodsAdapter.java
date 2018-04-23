package com.example.andre.food.adapters;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.andre.food.R;
import com.example.andre.food.data.Queries;
import com.example.andre.food.models.Food;

import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.ViewHolder>{

    private List<Food> foods= new Queries().foods();

    private FoodClickListener listener;

    public FoodsAdapter(FoodClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Food food= foods.get(position);
        holder.name.setText(food.getName());
        holder.type.setText(food.getType());
        holder.checkBox.setChecked(food.isDone());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int auxPosition= holder.getAdapterPosition();
                            Food auxFood= foods.get(auxPosition);
                            auxFood.setDone(true);

                            auxFood.save();
                            foods.remove(auxPosition);
                            notifyItemRemoved(auxPosition);
                        }
                    },400);
                }

            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Food auxFodd= foods.get(holder.getAdapterPosition());
                listener.ClickedID(auxFodd.getId());

            }
        });

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Food auxFodd= foods.get(holder.getAdapterPosition());
                listener.ClickedID(auxFodd.getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public void update(Food food){
        foods.add(food);
        notifyDataSetChanged();

    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private CheckBox checkBox;
        private TextView name;
        private TextView type;
        private LinearLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            checkBox=itemView.findViewById(R.id.foodCb);
            name= itemView.findViewById(R.id.foodNameTv);
            type=itemView.findViewById(R.id.foodTypeTv);
            itemLayout=itemView.findViewById(R.id.foodL1);

        }
    }
}
