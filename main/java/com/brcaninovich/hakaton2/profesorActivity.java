package com.brcaninovich.hakaton2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.brcaninovich.hakaton2.databinding.ActivityProfesorBinding;
import com.brcaninovich.hakaton2.recyclerNastavnik.RandomNumListAdapter5;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class profesorActivity extends AppCompatActivity {

    private ActivityProfesorBinding binding;
    private RecyclerView recyclerView;

    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static List<String> emailovi = new ArrayList<>();
    public static List<String> ime_prezime = new ArrayList<>();
    private static CollectionReference ucenik = db.collection("Ucenik");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfesorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recNastavnik);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(new RandomNumListAdapter5(1234));

    }


    public void nadji_ucenike(View view) {
        ucenik.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()){
                        emailovi.add(document.getId());
                    }
                }
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }



    public void test_funkcija(View view) {
        Log.d("Porukaa", profesorActivity.emailovi.get(1));
    }
}