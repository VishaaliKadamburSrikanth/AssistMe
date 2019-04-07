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


public class TransportFragment extends Fragment {
    private Button button;
    ActionBarDrawerToggle drawToggle;
    DrawerLayout drawLayout;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance) {
        return inflater.inflate(R.layout.fragment_transport, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Transport");
        //adding back button in the action bar
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

        Button btn_off4 = (Button) getActivity().findViewById(R.id.Button4);
        Button call = (Button) getActivity().findViewById(R.id.button5);
        btn_off4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://halifaxairporttcab.com/?gclid=CjwKCAjwm-fkBRBBEiwA966fZBPwkNY_ApifL-mmR6VoMuL0-HJj9OCbKtn1SKD9DzESDmhDpFmZVRoClLEQAvD_BwE\n"));
                getActivity().startActivity(i);

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 902_410_7415"));
                startActivity(callIntent);

            }
        });

    }
}












