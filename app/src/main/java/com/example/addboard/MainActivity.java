package com.example.addboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);


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
                Toast.makeText(this,"ac_sign_up",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.ac_sign_in:{
                Toast.makeText(this,"ac_sign_in",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.ac_sign_out:{
                Toast.makeText(this,"ac_sign_out",Toast.LENGTH_SHORT).show();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}