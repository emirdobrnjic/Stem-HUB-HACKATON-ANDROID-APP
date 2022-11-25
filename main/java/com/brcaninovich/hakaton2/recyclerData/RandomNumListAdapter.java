package com.brcaninovich.hakaton2.recyclerData;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.MainActivityTest;
import com.brcaninovich.hakaton2.R;

import java.util.Random;

public class RandomNumListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Random random;
    private Integer brojac = 0;



    public RandomNumListAdapter(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.recyler_view_row;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        int broj = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Porukaa", String.valueOf(broj) );
            }
        });

        //holder.getView().setText(String.valueOf(random.nextInt()));
        if(brojac == 0){
            holder.getView().setText(MainActivityTest.title1);
            holder.getView2().setText(MainActivityTest.description1);
        }else if (brojac == 1){
            holder.getView().setText(MainActivityTest.title2);
            holder.getView2().setText(MainActivityTest.description2);
        }
        else if (brojac == 2){
            holder.getView().setText(MainActivityTest.title3);
            holder.getView2().setText(MainActivityTest.description3);
        }
        else if (brojac == 3){
            holder.getView().setText(MainActivityTest.title4);
            holder.getView2().setText(MainActivityTest.description4);
        }
        brojac++;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}