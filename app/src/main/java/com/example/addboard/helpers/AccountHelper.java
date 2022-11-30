package com.example.addboard.helpers;

import android.widget.Toast;

import com.example.addboard.MainActivity;
import com.example.addboard.R;
import com.google.firebase.auth.FirebaseUser;

public class AccountHelper {

    MainActivity act;

    public AccountHelper(MainActivity  act){
        this.act =act;
    }

    public void signUpWithEmail(String email,String password){
        if (!email.isEmpty() && !password.isEmpty()){
            act.mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(act, R.string.info_successfully_sign_in,Toast.LENGTH_SHORT).show();
                    sendVerificationMessage(task.getResult().getUser());
                    act.uiUpdate(task.getResult().getUser());
                }else{
                    Toast.makeText(act, R.string.info_error_sign_up,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void signInWithEmail(String email,String password) {
        if (!email.isEmpty() && !password.isEmpty()){
            act.mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
               if (task.isSuccessful()){
                   act.uiUpdate(task.getResult().getUser());
               }else{
                   Toast.makeText(act, R.string.info_error_sign_in,Toast.LENGTH_SHORT).show();

               }
            });
        }
    }

    private void sendVerificationMessage(FirebaseUser user){
        user.sendEmailVerification().addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Toast.makeText(act,R.string.info_ver_message,Toast.LENGTH_SHORT);
            }else{
                Toast.makeText(act,R.string.info_error_send_message,Toast.LENGTH_SHORT);
            }
        });
    }


}
