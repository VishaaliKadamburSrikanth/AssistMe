package com.example.menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;

public class AccomodationFragment extends Fragment {
    ActionBarDrawerToggle drawToggle;
    DrawerLayout drawLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {
        return inflater.inflate(R.layout.fragment_accomodation, container, false);
    }

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    //adding back button in the action bar
    ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
    actionBar.setTitle("Accomodation");

    Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
    ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
    drawLayout = (DrawerLayout)getActivity().findViewById(R.id.drawer_layout);
    drawToggle = new ActionBarDrawerToggle(getActivity(), drawLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawLayout.setDrawerListener(drawToggle);
    drawToggle.syncState();
    drawToggle.setDrawerIndicatorEnabled(false);
    actionBar.setDisplayHomeAsUpEnabled(true);
    drawToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawLayout.openDrawer(GravityCompat.START);
        }
    });

    Button btn_off2 = (Button) getActivity().findViewById(R.id.Button);
    btn_off2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.kijiji.ca/\n"));
            getActivity().startActivity(i);

        }
    });

    Button btn_off3 = (Button) getActivity().findViewById(R.id.Button1);
    btn_off3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.airbnb.ca/\n"));
            getActivity().startActivity(i);

        }
    });


    Button btn_off5= (Button) getActivity().findViewById(R.id.Button3);
    btn_off5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://killamreit.com/\n"));
            getActivity().startActivity(i);

        }
    });

}

}

