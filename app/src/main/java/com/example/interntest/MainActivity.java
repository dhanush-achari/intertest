package com.example.interntest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.interntest.adapters.VerticalRecyclerViewAdapter;
import com.example.interntest.adapters.models.HorizontalModel;
import com.example.interntest.adapters.models.VerticalModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewAdapter adapter;
    ArrayList<VerticalModel> arrayListVertical;

//    String url="https://gaming-panda.df.r.appspot.com/intern_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayListVertical = new ArrayList<>();
        verticalRecyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        verticalRecyclerView.setHasFixedSize(true);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter= new VerticalRecyclerViewAdapter(this,arrayListVertical);
        verticalRecyclerView.setAdapter(adapter);
        setData();
    }

    private void setData() {


        for(int i=1; i<=5; i++){
            VerticalModel verticalModel= new VerticalModel();
            verticalModel.setCategory("Category"+i);
            ArrayList<HorizontalModel> arrayListHorizontal = new ArrayList<>();

            for(int j=1;j<=5;j++){
                HorizontalModel horizontalModel= new HorizontalModel();
                horizontalModel.setTitle("title"+j);
                arrayListHorizontal.add(horizontalModel);
            }
            verticalModel.setArrayList(arrayListHorizontal);
            arrayListVertical.add(verticalModel);
        }
        adapter.notifyDataSetChanged();
    }
}