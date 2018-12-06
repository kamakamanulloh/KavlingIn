package com.putri.skripsi.kavlingin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.putri.skripsi.kavlingin.MenuFragment.HomeFragment;
import com.putri.skripsi.kavlingin.MenuFragment.ProfilFragment;
import com.putri.skripsi.kavlingin.MenuFragment.TabTransaksiFragment;
import com.putri.skripsi.kavlingin.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Intent intent;
    public static final String TAG_id = "id";
    String id;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment=new HomeFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content, fragment)
                            .commit();

                    return true;
                case R.id.navigation_dashboard:
                    fragment=new TabTransaksiFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content, fragment)
                            .commit();

                    return true;
                case R.id.navigation_notifications:
                    fragment=new ProfilFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content, fragment)
                            .commit();

                    return true;
            }
            return loadfragment(fragment);
        }


    };
    private boolean loadfragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadfragment(new HomeFragment());
        intent=getIntent();
        id=intent.getStringExtra(TAG_id);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuitem, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bnt_post:
                Intent i = new Intent(MainActivity.this, PostActivity.class);
                intent.putExtra(TAG_id,LoginActivity.id);
                startActivity(i);
                break;
            case R.id.btn_lokasi:
                 i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
                break;


        }
        return false;
    }



}
