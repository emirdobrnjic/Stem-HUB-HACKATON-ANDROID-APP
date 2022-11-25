package com.brcaninovich.hakaton2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.brcaninovich.hakaton2.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    ProgressDialog progressdialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        progressdialog = new ProgressDialog(this);

        MainActivityTest.fetcData();
        MainActivityTest.fetcData2();
        MainActivityTest.fetcData3();
        MainActivityTest.fetcData4();






        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //auth();
                //MainActivityTest.class
                //profesorActivity.class
                Intent intent = new Intent(MainActivity.this, profesorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    public void login(){
        String email = binding.EmailET.getText().toString();
        String password = binding.PasswordET.getText().toString();

        if(email.isEmpty()){
            binding.EmailET.setError("Ukucaj email");
        }else if(password.isEmpty()){
            binding.PasswordET.setError("Ukucaj password");
        }else{
            progressdialog.setMessage("Prijava u toku...");
            progressdialog.setTitle("Prijava");
            progressdialog.setCanceledOnTouchOutside(false);
            progressdialog.show();
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressdialog.setMessage("Skidanje podataka u toku...");
                        UserDataFetch.fetcData2();
                        UserDataFetch.fetcRaspored();
                        progressdialog.dismiss();
                        novi_intent();
                    }else{
                        progressdialog.dismiss();
                        Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void novi_intent(){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void auth() {
        String email = binding.EmailET.getText().toString();
        String password = binding.PasswordET.getText().toString();

        if(email.isEmpty()){
            binding.EmailET.setError("Ukucaj email");
        }else if(password.isEmpty()){
            binding.PasswordET.setError("Ukucaj password");
        }else {
            progressdialog.setMessage("Prijava u toku...");
            progressdialog.setTitle("Prijava");
            progressdialog.setCanceledOnTouchOutside(false);
            progressdialog.show();
            mAuth.createUserWithEmailAndPassword("sadasd@kdadks.com", "123456").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        novi_intent();
                    } else {
                        Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}