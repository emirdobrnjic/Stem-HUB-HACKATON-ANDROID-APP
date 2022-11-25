package com.brcaninovich.hakaton2.recyclerViewOcjene;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.R;
import com.brcaninovich.hakaton2.UserDataFetch;
import com.brcaninovich.hakaton2.recyclerDataRaspored.RecyclerViewHolderRaspored;

import java.util.Random;

public class RandomNumListAdapter3 extends RecyclerView.Adapter<RecyclerViewHolderOcjene> {
    private Random random;
    private Integer brojac = 0;




    public RandomNumListAdapter3(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.recyler_view_row_ocjene;
    }

    @NonNull
    @Override
    public RecyclerViewHolderOcjene onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolderOcjene(view);
    }


    String vrati_string(String[] string,int broj){

        if(broj >= string.length) {
            return  "_";
        }else{
            return  string[broj];
        }
    }




    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderOcjene holder, int position) {

        //holder.getView().setText(String.valueOf(random.nextInt()));
            String[] stringArr = UserDataFetch.predmeti_ocjene.get(brojac).split(",");


            holder.getView10().setText(vrati_string(stringArr, 0));
            holder.getView2().setText(vrati_string(stringArr, 1));
            holder.getView3().setText(vrati_string(stringArr, 2));
            holder.getView4().setText(vrati_string(stringArr, 3));
            holder.getView5().setText(vrati_string(stringArr, 4));
            holder.getView6().setText(vrati_string(stringArr, 5));
            holder.getView7().setText(vrati_string(stringArr, 6));
            holder.getView8().setText(vrati_string(stringArr, 7));
            holder.getView9().setText(vrati_string(stringArr, 8));

            brojac++;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}