package com.zackratos.ultimatebarx.sample;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.zackratos.ultimatebarx.library.UltimateBarX;


/**
 * @Author : Zackratos
 * @Date : 2020/7/11 3:58
 * @email : 869649338@qq.com
 * @Describe :
 */
public class DrawerActivity extends AppCompatActivity {

    TextFragment2 mainFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        UltimateBarX.create(UltimateBarX.NAVIGATION_BAR)
                .fitWindow(true)
                .bgColor(Color.RED)
                .apply(this);
        initMainFragment();
        addFragment();
    }

    private void initMainFragment() {
        mainFragment = TextFragment2.Companion.newInstance(Color.RED, "九阴真经", Color.WHITE,
                fragment -> {
                    UltimateBarX.create(UltimateBarX.STATUS_BAR)
                            .bgColor(Color.RED)
                            .fitWindow(true)
                            .apply(fragment);
                    initToolbar(fragment);
                    return null;
                });
    }

    private void initToolbar(Fragment fragment) {
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = fragment.requireView().findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void addFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flMain, mainFragment)
                .add(R.id.flDrawer, DrawerFragment.newInstance())
                .commit();
    }
}