package com.brcaninovich.hakaton2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.brcaninovich.hakaton2.databinding.ActivityMainKomentarBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivityKomentar extends AppCompatActivity {

    ActivityMainKomentarBinding binding;
    EditText text;
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static List<String> temp = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainKomentarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }

    public void saveNote2(String view) {

        Map<String, Object> note = new HashMap<>();
        note.put("Permisija", "ucenik");
        note.put("Ime_Prezime", UserDataFetch.ime_prezime);
        note.put("Predmeti_Ocjene", UserDataFetch.predmeti_ocjene);
        note.put("Izostanci_Opravdani", UserDataFetch.izostanci_opravdani);
        note.put("Izostanci_nepravdani", UserDataFetch.izostanci_neopravdani);
        note.put("vladanje", UserDataFetch.vladanje);
        note.put("email", UserDataFetch.email);
        note.put("Komentar", temp);



        db.collection("Ucenik").document(UserDataFetch.email).set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
    }

    public void ssss(View view) {
        temp.add(0, "Ukor," + binding.editTextTextPersonName.getText() + "," + "20.11.2022");
        saveNote2(UserDataFetch.email);

    }
}