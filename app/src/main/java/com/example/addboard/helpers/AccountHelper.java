package com.example.addboard.helpers;

import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.addboard.MainActivity;
import com.example.addboard.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class AccountHelper {

    MainActivity act;

    public AccountHelper(MainActivity  act){
        this.act =act;
    }

    public void signUpWithEmail(String email,String password){
        if (!email.isEmpty() && !password.isEmpty()){
            Toast.makeText(act,"here",Toast.LENGTH_SHORT).show();
            act.mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(act,"we send to you verification message",Toast.LENGTH_SHORT).show();
                    sendVerificationMessage(task.getResult().getUser());
                }else{
                    Toast.makeText(act,"texte erore",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void sendVerificationMessage(FirebaseUser user){
        user.sendEmailVerification().addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Toast.makeText(act,"we send ver message",Toast.LENGTH_SHORT);
            }else{
                Toast.makeText(act,"errore",Toast.LENGTH_SHORT);
            }
        });
    }
}
