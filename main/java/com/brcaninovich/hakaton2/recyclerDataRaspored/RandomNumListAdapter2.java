package com.brcaninovich.hakaton2.recyclerDataRaspored;

import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.MainActivityTest;
import com.brcaninovich.hakaton2.R;
import com.brcaninovich.hakaton2.UserDataFetch;
import com.brcaninovich.hakaton2.recyclerData.RecyclerViewHolder;

import java.util.Random;

public class RandomNumListAdapter2 extends RecyclerView.Adapter<RecyclerViewHolderRaspored> {
    private Random random;
    private Integer brojac = 0;
            Integer broj = UserDataFetch.raspored_casova.size();




    public RandomNumListAdapter2(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.recycler_view_row_raspored;
    }

    @NonNull
    @Override
    public RecyclerViewHolderRaspored onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolderRaspored(view);
    }


    String vrati_string(String[] string,int broj){

        if(broj >= string.length) {
            return  "Slobodan cas";
        }else{
            return  string[broj];
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderRaspored holder, int position) {

        //holder.getView().setText(String.valueOf(random.nextInt()));
            String[] stringArr = UserDataFetch.raspored_casova.get(brojac).split(",");


            holder.getView().setText(vrati_string(stringArr, 0));
            holder.getView2().setText("-" + vrati_string(stringArr, 1));
            holder.getView3().setText("-" + vrati_string(stringArr, 2));
            holder.getView4().setText("-" + vrati_string(stringArr, 3));
            holder.getView5().setText("-" + vrati_string(stringArr, 4));
            holder.getView6().setText("-" + vrati_string(stringArr, 5));
            holder.getView7().setText("-" + vrati_string(stringArr, 6));

            brojac++;
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}