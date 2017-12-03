package com.motionlaboratory.meesier;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.motionlaboratory.meesier.AppConfig.SessionManager;
import com.motionlaboratory.meesier.Fragment.AkunFragment;
import com.motionlaboratory.meesier.Fragment.MainFragment;
import com.motionlaboratory.meesier.Fragment.MessageFragment;
import com.motionlaboratory.meesier.Fragment.NotificationFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if(sessionManager.checkLogin()){
            finish();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_bottom);
        //bottomNavigationView.inflateMenu(R.menu.menu_bottom_bar);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameLayout, new MainFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.menu_main:
                                fragment = new MainFragment();
                                setTitle("Maveer");
                                break;

                            case R.id.menu_message:
                                fragment = new MessageFragment();
                                setTitle("Pesan");
                                break;

                            case R.id.menu_profile:
                                fragment = new AkunFragment();
                                setTitle("Akun");
                                break;

                            case R.id.menu_notif:
                                fragment = new NotificationFragment();
                                setTitle("Pemberitahuan");
                                break;
                        }

                        final FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.frameLayout,fragment).commit();
                        return true;
                    }
                });
    }
}