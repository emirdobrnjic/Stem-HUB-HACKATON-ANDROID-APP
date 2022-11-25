package com.brcaninovich.hakaton2.recyclerNastavnik;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.R;

public class RecyclerViewHolderNastavnik extends RecyclerView.ViewHolder {

    private TextView view;
    private TextView view2;
    public RecyclerViewHolderNastavnik(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.imePrezime);
        view2 = itemView.findViewById(R.id.emailStudenta);
    }

    public TextView getView(){
        return view;
    }
    public TextView getView2(){
        return view2;
    }
}