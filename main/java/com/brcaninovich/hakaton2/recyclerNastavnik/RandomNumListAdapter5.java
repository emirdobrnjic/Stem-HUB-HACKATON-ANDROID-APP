package com.brcaninovich.hakaton2.recyclerNastavnik;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.MainActivity;
import com.brcaninovich.hakaton2.MainActivity2;
import com.brcaninovich.hakaton2.MainActivity3;
import com.brcaninovich.hakaton2.MainActivityTest;
import com.brcaninovich.hakaton2.R;
import com.brcaninovich.hakaton2.UserDataFetch;
import com.brcaninovich.hakaton2.profesorActivity;
import com.brcaninovich.hakaton2.recyclerData.RecyclerViewHolder;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class RandomNumListAdapter5 extends RecyclerView.Adapter<RecyclerViewHolderNastavnik> {
    private Random random;
    private Integer brojac = 0;
    public static String email;



    public RandomNumListAdapter5(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.recyler_nastavnik;
    }

    @NonNull
    @Override
    public RecyclerViewHolderNastavnik onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolderNastavnik(view);
    }




    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderNastavnik holder, int position) {

        int broj = position;

        if(brojac == 0){
            holder.getView().setText("Novi Ucenik");
            holder.getView2().setText("test@test.com");
            email = "novi.ucenik@gmail.com";
        }else if (brojac == 1){
            holder.getView().setText("Novi Ucenik2");
            holder.getView2().setText("novi.ucenik2@gmail.com");
            email = "novi.ucenik2@gmail.com";
        }
        else if (brojac == 2){
            holder.getView().setText("Novi Ucenik3");
            holder.getView2().setText("novi.ucenik3@gmail.com");
            email = "novi.ucenik3@gmail.com";
        }else if (brojac == 3){
            holder.getView().setText("Novi Ucenik4");
            holder.getView2().setText("novi.ucenik4@gmail.com");
            email = "novi.ucenik4@gmail.com";
        } else if (brojac == 4){
            holder.getView().setText("Novi Ucenik5");
            holder.getView2().setText("novi.ucenik5@gmail.com");
            email = "novi.ucenik5@gmail.com";
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    UserDataFetch.fetcData(email);
                    Intent intent = new Intent(view.getContext(), MainActivity3.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    holder.itemView.getContext().startActivity(intent);
            }
        });


        brojac++;

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}