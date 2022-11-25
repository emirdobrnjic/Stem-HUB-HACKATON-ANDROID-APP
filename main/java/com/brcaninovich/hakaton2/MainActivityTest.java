package com.brcaninovich.hakaton2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.brcaninovich.hakaton2.databinding.ActivityMainTestBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivityTest extends AppCompatActivity {
    private static final String TAG = "MainActivityTest";

    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";

    private static final String KEY_TITLE2 = "title";
    private static final String KEY_DESCRIPTION2 = "description";

    private static final String KEY_TITLE3 = "title";
    private static final String KEY_DESCRIPTION3 = "description";

    private static final String KEY_TITLE4 = "title";
    private static final String KEY_DESCRIPTION4 = "description";


    public static String title1;
    public static String description1;

    public static String title2;
    public static String description2;

    public static String title3;
    public static String description3;

    public static String title4;
    public static String description4;





    static ActivityMainTestBinding binding;

    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static DocumentReference noteRef = db.collection("Notebook").document("My first Note");
    private static DocumentReference noteRef2 = db.collection("Notebook").document("My second Note");
    private static DocumentReference noteRef3 = db.collection("Notebook").document("My third Note");
    private static DocumentReference noteRef4 = db.collection("Notebook").document("My fourth Note");
    private static DocumentReference noteRef5 = db.collection("Ucenik").document("test@test.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        noteRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if(value.exists()){
                    String title = value.getString(KEY_TITLE);
                    String description = value.getString(KEY_DESCRIPTION);

                    //Map<String, Object> note = documentSnapshot.getData();
                    binding.textViewData.setText("title: " + title + "\n" + "Description: " + description);
                }
            }
        });
    }*/

    public static void fetcData(){
        noteRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    title1 = documentSnapshot.getString(KEY_TITLE);
                     description1 = documentSnapshot.getString(KEY_DESCRIPTION);
                }else{
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.toString());
            }
        });

        noteRef2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    title2 = documentSnapshot.getString(KEY_TITLE);
                    description2 = documentSnapshot.getString(KEY_DESCRIPTION);
                }else{
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.toString());
            }
        });

        noteRef3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    title3 = documentSnapshot.getString(KEY_TITLE3);
                    description3 = documentSnapshot.getString(KEY_DESCRIPTION3);
                }else{
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.toString());
            }
        });

        noteRef4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    title4 = documentSnapshot.getString(KEY_TITLE4);
                    description4 = documentSnapshot.getString(KEY_DESCRIPTION4);
                }else{
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.toString());
            }
        });
    }
    public static void fetcData2(){
        noteRef2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    title2 = documentSnapshot.getString(KEY_TITLE);
                    description2 = documentSnapshot.getString(KEY_DESCRIPTION);
                }else{
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.toString());
            }
        });
    }
    public static void fetcData3(){
        noteRef3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    title3 = documentSnapshot.getString(KEY_TITLE3);
                    description3 = documentSnapshot.getString(KEY_DESCRIPTION3);
                }else{
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.toString());
            }
        });
    }
    public static void fetcData4(){

        noteRef4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    title4 = documentSnapshot.getString(KEY_TITLE4);
                    description4 = documentSnapshot.getString(KEY_DESCRIPTION4);
                }else{
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.toString());
            }
        });
    }

    public void saveNote(View view) {
        String title = binding.editTextTitle2.getText().toString();
        String description = binding.editTextDescription.getText().toString();

        Map<String, Object> note = new HashMap<>();
        note.put("Permisija", "ucenik");
        note.put("Ime_Prezime", "Test Testic");
        note.put("Predmeti_Ocjene", Arrays.asList("Matematika,5,5,5,5", "BHS,5,3,5,5", "Engleski,4,4,5,5"));
        note.put("Raspored_Casova", Arrays.asList(
                "Ponedjeljak,Matematika,Tjelesni,Tjelesni,Hemija,BHS,Engleski",
                "Utorak,Matematika,Tjelesni,Tjelesni,Hemija",
                "Srijeda,Matematika,Tjelesni,Tjelesni",
                "Cetvrtak,Matematika,Tjelesni,Tjelesni,Hemija,BHS",
                "Petak,Matematika,Tjelesni,Tjelesni,Hemija,BHS"));
        note.put("Izostanci_Opravdani", "11");
        note.put("Izostanci_nepravdani", "3");
        note.put("vladanje", "primjerno");
        note.put("email", "test.test@gmail.com");
        note.put("Komentar", Arrays.asList(
                "Pohvala, Ucenik je ostvario odlican rezultat na danasnjem testu",
                "Ukor, Ucenik je napravio problem u skoli u kojem je intervenisala i hitna pomoc"));



        db.collection("Ucenik").document("test@test.com").set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivityTest.this, "Note saved", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivityTest.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }

    /*public void saveNote(View view) {
        Map<String, Object> note = new HashMap<>();
        note.put("Permisija", "Ucitelj");
        note.put("Ime_Prezime", "Test Testic");
        note.put("Predmet", "Predmet Predaje");



        db.collection("Ucitelj").document("ucitelj@test.com").set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivityTest.this, "Note saved", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivityTest.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }*/

    /*public void saveNote(View view) {

        Map<String, Object> note = new HashMap<>();
        note.put("Raspored_Casova", Arrays.asList(
                "Ponedjeljak,Matematika,Tjelesni,Tjelesni,Hemija,BHS,Engleski",
                "Utorak,Matematika,Tjelesni,Tjelesni,Hemija",
                "Srijeda,Matematika,Tjelesni,Tjelesni",
                "Cetvrtak,Matematika,Tjelesni,Tjelesni,Hemija,BHS",
                "Petak,Matematika,Tjelesni,Tjelesni,Hemija,BHS"));


        db.collection("Raspored").document("raspored").set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivityTest.this, "Note saved", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivityTest.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }*/

    public void saveNote2(View view) {
        String title = binding.editTextTitle2.getText().toString();
        String description = binding.editTextDescription.getText().toString();

        Map<String, Object> note = new HashMap<>();
        note.put(KEY_TITLE2, title);
        note.put(KEY_DESCRIPTION2, description);

        db.collection("Notebook").document("My second Note").set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivityTest.this, "Note saved", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivityTest.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }

    public void saveNote3(View view) {
        String title = binding.editTextTitle2.getText().toString();
        String description = binding.editTextDescription.getText().toString();

        Map<String, Object> note = new HashMap<>();
        note.put(KEY_TITLE3, title);
        note.put(KEY_DESCRIPTION3, description);

        db.collection("Notebook").document("My third Note").set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivityTest.this, "Note saved", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivityTest.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }

    public void saveNote4(View view) {
        String title = binding.editTextTitle2.getText().toString();
        String description = binding.editTextDescription.getText().toString();

        Map<String, Object> note = new HashMap<>();
        note.put(KEY_TITLE4, title);
        note.put(KEY_DESCRIPTION4, description);

        db.collection("Notebook").document("My fourth Note").set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivityTest.this, "Note saved", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivityTest.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }

    public void LoadNote(View view) {
        noteRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    String title = documentSnapshot.getString(KEY_TITLE);
                    String description = documentSnapshot.getString(KEY_DESCRIPTION);

                    //Map<String, Object> note = documentSnapshot.getData();
                    binding.textViewData.setText("title: " + title + "\n" + "Description: " + description);
                }else{
                    Toast.makeText(MainActivityTest.this, "Document does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivityTest.this, "error", Toast.LENGTH_SHORT).show();
                Log.d(TAG, e.toString());
            }
        });
    }
}