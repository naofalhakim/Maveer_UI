package com.motionlaboratory.meesier;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.motionlaboratory.meesier.Fragment.MapLokasiFragment;
import com.motionlaboratory.meesier.Fragment.SewaLokasiFragment;

public class LokasiAcaraActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokasi_acara);

        tabLayout = (TabLayout) findViewById(R.id.tab_lokasi);
        viewPager = (ViewPager) findViewById(R.id.viewpager_lokasi);

        myAdapter = new MyAdapter(getSupportFragmentManager());

        viewPager.setAdapter(myAdapter);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

    }

    public class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new MapLokasiFragment();
                case 1: return new SewaLokasiFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0 :
                        return "SUDAH ADA";
                    case 1:
                        return "SEWA";
                }
                return null;
        }
    }
}
