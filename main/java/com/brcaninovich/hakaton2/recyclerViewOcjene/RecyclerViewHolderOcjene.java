package com.brcaninovich.hakaton2.recyclerViewOcjene;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.R;

public class RecyclerViewHolderOcjene extends RecyclerView.ViewHolder {

    private TextView view;
    private TextView view2;
    private TextView view3;
    private TextView view4;
    private TextView view5;
    private TextView view6;
    private TextView view7;
    private TextView view8;
    private TextView view9;
    private TextView view10;

    public RecyclerViewHolderOcjene(@NonNull View itemView) {
        super(itemView);

        view2 = itemView.findViewById(R.id.ocjena_1);
        view3 = itemView.findViewById(R.id.ocjena_2);
        view4 = itemView.findViewById(R.id.ocjena_3);
        view5 = itemView.findViewById(R.id.ocjena_4);
        view6 = itemView.findViewById(R.id.ocjena_5);
        view7 = itemView.findViewById(R.id.ocjena_6);
        view8 = itemView.findViewById(R.id.ocjena_7);
        view9 = itemView.findViewById(R.id.ocjena_8);
        view10 = itemView.findViewById(R.id.predmetTV);
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
    public TextView getView8(){
        return view8;
    }
    public TextView getView9(){
        return view9;
    }
    public TextView getView10(){
        return view10;
    }
}

