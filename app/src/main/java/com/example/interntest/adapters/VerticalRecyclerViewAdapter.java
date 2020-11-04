package com.example.interntest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interntest.R;
import com.example.interntest.adapters.models.HorizontalModel;
import com.example.interntest.adapters.models.VerticalModel;

import java.util.ArrayList;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalRVViewHolder> {
    Context context;
    ArrayList<VerticalModel> arrayList;
    public VerticalRecyclerViewAdapter(Context context, ArrayList<VerticalModel> arrayList){
        this.arrayList=arrayList;
        this.context=context;

    }

    @NonNull
    @Override
    public VerticalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical,parent,false);
        return new VerticalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalRVViewHolder holder, int position) {
        VerticalModel verticalModel = arrayList.get(position);
        String Category=verticalModel.getCategory();
        ArrayList<HorizontalModel> singleItem=verticalModel.getArrayList();

        holder.category.setText(Category);
        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter= new HorizontalRecyclerViewAdapter(context,singleItem);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(horizontalRecyclerViewAdapter);
        holder.btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, verticalModel.getCategory(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class VerticalRVViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView category;
        Button btnmore;

        public VerticalRVViewHolder(@NonNull View itemView) {
            super(itemView);
            btnmore=(Button)itemView.findViewById(R.id.btnmore) ;
            recyclerView=(RecyclerView)itemView.findViewById(R.id.recyclerview1);
            category=(TextView)itemView.findViewById(R.id.category1);


        }
    }
}
