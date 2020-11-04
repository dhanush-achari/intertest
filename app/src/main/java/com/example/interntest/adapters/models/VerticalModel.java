package com.example.interntest.adapters.models;

import java.util.ArrayList;

public class VerticalModel {
    String category;
    ArrayList<HorizontalModel> arrayList ;

    public ArrayList<HorizontalModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<HorizontalModel> arrayList) {
        this.arrayList = arrayList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
