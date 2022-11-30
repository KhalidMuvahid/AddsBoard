package com.example.addboard;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.addboard.databinding.ActivityMainBinding;
import com.example.addboard.helpers.DialogHelper;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private ActivityMainBinding binding;
    private DialogHelper dialogHelper;
    public FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialogHelper = new DialogHelper(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,binding.drawerLayout,binding.mainContent.toolbar,R.string.open,R.string.close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        binding.navView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.my_ads:{
                Toast.makeText(this,"my_ads",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.ad_cars:{
                Toast.makeText(this,"cars",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.ad_pc:{
                Toast.makeText(this,"ad_pc",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.ad_smartphone:{
                Toast.makeText(this,"ad_smartphone",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.ad_dm:{
                Toast.makeText(this,"ad_dm",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.ac_sign_up:{
                dialogHelper.createDialog(dialogHelper.SIGN_UP_STATE);
                break;
            }
            case R.id.ac_sign_in:{
                dialogHelper.createDialog(dialogHelper.SIGN_IN_STATE);
                break;
            }
            case R.id.ac_sign_out:{
                dialogHelper.createDialog(dialogHelper.SIGN_OUT_STATE);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}