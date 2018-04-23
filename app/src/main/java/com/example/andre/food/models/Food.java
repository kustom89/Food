package com.example.andre.food.models;

import com.orm.SugarRecord;

public class Food extends SugarRecord {

    private String name, type;
    private boolean done;

    public Food() {
    }

    public Food(String name, String type, boolean done) {
        this.name = name;
        this.type = type;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
