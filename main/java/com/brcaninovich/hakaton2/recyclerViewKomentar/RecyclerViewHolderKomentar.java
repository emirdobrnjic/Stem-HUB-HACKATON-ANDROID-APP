package com.brcaninovich.hakaton2.recyclerViewKomentar;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.R;

public class RecyclerViewHolderKomentar extends RecyclerView.ViewHolder {

    private TextView view;
    private TextView view2;
    private TextView view4;
    private CardView view3;


    public RecyclerViewHolderKomentar(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.komentar);
        view2 = itemView.findViewById(R.id.komentarHolder);
        view4 = itemView.findViewById(R.id.datumHolder);
        view3 = itemView.findViewById(R.id.kartica);


    }

    public TextView getView(){
        return view;
    }
    public TextView getView2(){
        return view2;
    }
    public TextView getView4(){
        return view4;
    }
    public CardView getView3(){
        return view3;
    }

}

