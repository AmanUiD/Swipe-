package com.example.swipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.swipe.Fragment.EventFragment;
import com.example.swipe.Fragment.FolderFragment;
import com.example.swipe.Fragment.InboxFragment;
import com.example.swipe.Fragment.SaveFragment;
import com.example.swipe.Fragment.StarFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FolderFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.folder:
                            selectedFragment = new FolderFragment();
                            break;
                        case R.id.star:
                            selectedFragment = new StarFragment();
                            break;

                        case R.id.inbox:
                            selectedFragment = new InboxFragment();
                            break;
                        case R.id.event:
                            selectedFragment = new EventFragment();
                            break;
                        case R.id.save:
                            selectedFragment = new SaveFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }
            };

}