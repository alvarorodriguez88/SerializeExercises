package org.example.model;


import org.example.model.Session;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private String name;
    private int capacity;

    public Theater(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

