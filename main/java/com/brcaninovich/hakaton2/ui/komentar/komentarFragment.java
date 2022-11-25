package com.brcaninovich.hakaton2.ui.komentar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.R;
import com.brcaninovich.hakaton2.UserDataFetch;
import com.brcaninovich.hakaton2.databinding.FragmentIzostanciBinding;
import com.brcaninovich.hakaton2.databinding.FragmentKomentarBinding;
import com.brcaninovich.hakaton2.recyclerDataRaspored.RandomNumListAdapter2;
import com.brcaninovich.hakaton2.recyclerViewKomentar.RandomNumListAdapter4;

public class komentarFragment extends Fragment {

private FragmentKomentarBinding binding;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                        ViewGroup container, Bundle savedInstanceState) {
                        komentarViewModel komentarViewModel =
                        new ViewModelProvider(this).get(komentarViewModel.class);

    binding = FragmentKomentarBinding.inflate(inflater, container, false);
    View root = binding.getRoot();



        recyclerView = root.findViewById(R.id.recyclervieKomentar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(new RandomNumListAdapter4(1234));

        //final TextView textView = binding.textHome;
        //izostanciViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}