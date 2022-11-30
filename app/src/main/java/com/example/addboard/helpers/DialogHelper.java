package com.example.addboard.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.example.addboard.MainActivity;
import com.example.addboard.R;
import com.example.addboard.databinding.SignDialogBinding;



public class DialogHelper {
    MainActivity act;
    SignDialogBinding binding;
    private AccountHelper accHelper;

    public final int SIGN_OUT_STATE = 0;
    public final int SIGN_IN_STATE = 1;
    public final int SIGN_UP_STATE = 2;


    public DialogHelper(MainActivity act){
        binding = SignDialogBinding.inflate(act.getLayoutInflater());
        this.act = act;
        accHelper = new AccountHelper(act);
    }

    public void createDialog(int index){
        AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setView(binding.getRoot());

        AlertDialog dialog = builder.create();
        switch (index){
            case  SIGN_UP_STATE:{
                binding.dialogTitle.setText(R.string.ac_sign_up);
                binding.dialogSignInBt.setVisibility(View.GONE);
                break;
            }
            case  SIGN_IN_STATE:{
                binding.dialogTitle.setText(R.string.ac_sign_in);
                break;
            }

        }

        binding.dialogSignUpBt.setOnClickListener(v -> {
            if (index == SIGN_UP_STATE){
                String email  =binding.emailEdT.getEditText().getText().toString();
                String password  =binding.passwordEdt.getEditText().getText().toString();
                accHelper.signUpWithEmail(email,password);
            }
            dialog.dismiss();
        });

        binding.dialogSignInBt.setOnClickListener(v->{
            String email  =binding.emailEdT.getEditText().getText().toString();
            String password  =binding.passwordEdt.getEditText().getText().toString();
            accHelper.signInWithEmail(email,password);
            dialog.dismiss();
        });

        dialog.show();
    }




}
