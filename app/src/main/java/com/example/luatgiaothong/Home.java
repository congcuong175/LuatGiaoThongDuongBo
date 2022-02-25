package com.example.luatgiaothong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Home extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chipNavigationBar=findViewById(R.id.chipNVGT);
        chipNavigationBar.setItemSelected(R.id.home,true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.home:
                        Navigation.findNavController(Home.this,R.id.nav_host_fragment_content_display_man).navigate(R.id.blankFragment);
                        break;
                    case R.id.activity:
                        Navigation.findNavController(Home.this,R.id.nav_host_fragment_content_display_man).navigate(R.id.blankFragment2);
                        break;
                    case R.id.favorites:
                        break;
                    case R.id.settings:
                        break;
                }
            }
        });
    }
}