package com.brcaninovich.hakaton2;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class UserDataFetch {

    static FirebaseAuth mAuth = FirebaseAuth.getInstance();
    static FirebaseUser mUser = mAuth.getCurrentUser();

    static String email = mUser.getEmail();

    public static String ime_prezime;
    public static List<String> predmeti_ocjene = new ArrayList<>();
    public static List<String> raspored_casova = new ArrayList<>();
    public static List<String> komentari = new ArrayList<>();
    public static String izostanci_opravdani;
    public static String izostanci_neopravdani;
    public static String vladanje;

    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static DocumentReference ucenik = db.collection("Ucenik").document(email);
    private static DocumentReference raspored = db.collection("Raspored").document("raspored");

    public static void fetcData2(){
        ucenik.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                        ime_prezime = documentSnapshot.getString("Ime_Prezime");
                        izostanci_opravdani = documentSnapshot.getString("Izostanci_Opravdani");
                        izostanci_neopravdani = documentSnapshot.getString("Izostanci_nepravdani");
                        vladanje = documentSnapshot.getString("vladanje");
                        predmeti_ocjene = (List<String>) documentSnapshot.get("Predmeti_Ocjene");
                        raspored_casova = (List<String>) documentSnapshot.get("Raspored_Casova");
                        komentari = (List<String>) documentSnapshot.get("Komentar");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }

    public static void fetcData(String email){
        DocumentReference ucenikk = db.collection("Ucenik").document(email);
        ucenikk.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    ime_prezime = documentSnapshot.getString("Ime_Prezime");
                    izostanci_opravdani = documentSnapshot.getString("Izostanci_Opravdani");
                    izostanci_neopravdani = documentSnapshot.getString("Izostanci_nepravdani");
                    vladanje = documentSnapshot.getString("vladanje");
                    predmeti_ocjene = (List<String>) documentSnapshot.get("Predmeti_Ocjene");
                    komentari = (List<String>) documentSnapshot.get("Komentar");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }

    public static void fetcRaspored(){
        raspored.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                        raspored_casova = (List<String>) documentSnapshot.get("Raspored_Casova");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

}
