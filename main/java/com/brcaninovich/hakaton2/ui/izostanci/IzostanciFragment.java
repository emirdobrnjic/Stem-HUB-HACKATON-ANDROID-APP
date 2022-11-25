package com.brcaninovich.hakaton2.ui.izostanci;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.brcaninovich.hakaton2.UserDataFetch;
import com.brcaninovich.hakaton2.databinding.FragmentIzostanciBinding;
import com.brcaninovich.hakaton2.databinding.FragmentRasporedBinding;
import com.brcaninovich.hakaton2.ui.raspored.RasporedViewModel;

public class IzostanciFragment extends Fragment {

private FragmentIzostanciBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        IzostanciViewModel izostanciViewModel =
                new ViewModelProvider(this).get(IzostanciViewModel.class);

    binding = FragmentIzostanciBinding.inflate(inflater, container, false);
    View root = binding.getRoot();



        //final TextView textView = binding.textHome;

        //DIO ZA FEC
        binding.neopravdaniHolder.setText(UserDataFetch.izostanci_neopravdani);
        binding.opravdaniHolder.setText(UserDataFetch.izostanci_opravdani);
        binding.vladanjeHolder.setText(vrati_normal(UserDataFetch.vladanje));

        if(vrati_normal(UserDataFetch.vladanje).equals("Primjerno")){
            binding.cardviewVladanje.setCardBackgroundColor(Color.parseColor("#97FF5E"));
        }else if(vrati_normal(UserDataFetch.vladanje).equals("Vrlo dobro")){
            binding.cardviewVladanje.setCardBackgroundColor(Color.parseColor("#C4F584"));
        }
        else if(vrati_normal(UserDataFetch.vladanje).equals("Dobro")){
            binding.cardviewVladanje.setCardBackgroundColor(Color.parseColor("#D9C72B"));
        }
        else if(vrati_normal(UserDataFetch.vladanje).equals("Zadovoljava")){
            binding.cardviewVladanje.setCardBackgroundColor(Color.parseColor("#D97C2B"));
        }
        else if(vrati_normal(UserDataFetch.vladanje).equals("Lose")){
            binding.cardviewVladanje.setCardBackgroundColor(Color.parseColor("#D82C2C"));
        }
        //final TextView textView = binding.textHome;
        //izostanciViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    String vrati_normal(String str){
        if (str == null || str.length() == 0) return str;
        str.toLowerCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}