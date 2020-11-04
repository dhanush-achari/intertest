package com.example.interntest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interntest.R;
import com.example.interntest.adapters.models.HorizontalModel;

import java.util.ArrayList;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HoriaontalRVViewHolder> {
    Context context;

    ArrayList<HorizontalModel> arrayList;
    public HorizontalRecyclerViewAdapter(Context context, ArrayList<HorizontalModel> singleItem) {
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public HoriaontalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,parent,false);
        return new HoriaontalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoriaontalRVViewHolder holder, int position) {
       final HorizontalModel horizontalModel  = arrayList.get(position);
        holder.textViewTitle.setText((horizontalModel.getTitle()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, horizontalModel.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class HoriaontalRVViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        ImageView imageViewThumb;

        public HoriaontalRVViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=(TextView)itemView.findViewById(R.id.txttitlehorizontal);
            imageViewThumb=(ImageView)itemView.findViewById(R.id.ivThumb);
        }
    }
}
