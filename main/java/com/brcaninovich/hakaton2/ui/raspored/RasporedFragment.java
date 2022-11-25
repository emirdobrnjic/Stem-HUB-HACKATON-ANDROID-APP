package com.brcaninovich.hakaton2.ui.raspored;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.brcaninovich.hakaton2.R;
import com.brcaninovich.hakaton2.databinding.FragmentRasporedBinding;
import com.brcaninovich.hakaton2.recyclerData.RandomNumListAdapter;
import com.brcaninovich.hakaton2.recyclerDataRaspored.RandomNumListAdapter2;

public class RasporedFragment extends Fragment {

private FragmentRasporedBinding binding;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {
                            RasporedViewModel rasporedViewModel =
                            new ViewModelProvider(this).get(RasporedViewModel.class);

    binding = FragmentRasporedBinding.inflate(inflater, container, false);
    View root = binding.getRoot();


        recyclerView = root.findViewById(R.id.recyclervieww);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(new RandomNumListAdapter2(1234));
        //final TextView textView = binding.textHome;
        //rasporedViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}