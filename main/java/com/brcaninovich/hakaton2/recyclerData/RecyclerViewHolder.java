package com.brcaninovich.hakaton2.recyclerData;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView view;
    private TextView view2;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.randomText);
        view2 = itemView.findViewById(R.id.randomText2);
    }

    public TextView getView(){
        return view;
    }
    public TextView getView2(){
        return view2;
    }
}