package com.brcaninovich.hakaton2.recyclerDataRaspored;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.R;

public class RecyclerViewHolderRaspored extends RecyclerView.ViewHolder {

    private TextView view;
    private TextView view2;
    private TextView view3;
    private TextView view4;
    private TextView view5;
    private TextView view6;
    private TextView view7;

    public RecyclerViewHolderRaspored(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.danSedmica);
        view2 = itemView.findViewById(R.id.cas1);
        view3 = itemView.findViewById(R.id.cas2);
        view4 = itemView.findViewById(R.id.cas3);
        view5 = itemView.findViewById(R.id.cas4);
        view6 = itemView.findViewById(R.id.cas5);
        view7 = itemView.findViewById(R.id.cas6);
    }

    public TextView getView(){
        return view;
    }
    public TextView getView2(){
        return view2;
    }
    public TextView getView3(){
        return view3;
    }
    public TextView getView4(){
        return view4;
    }
    public TextView getView5(){
        return view5;
    }
    public TextView getView6(){
        return view6;
    }
    public TextView getView7(){
        return view7;
    }
}

