package com.example.menu;


import android.content.Intent;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThingsToDoFragment extends Fragment {
    ActionBarDrawerToggle drawToggle;
    DrawerLayout drawLayout;
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {
        return inflater.inflate(R.layout.fragment_thingstodo, container, false);
    }


    @Override
   public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        //adding back button in the action bar
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Things to do");

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

        //retrieving the button id's and passing it to maps activity class
        Button ns= (Button)getActivity().findViewById(R.id.nsidButton);
        ns.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View v)
        {
            Intent intent = new Intent(getActivity(), MapsActivity.class);
            intent.putExtra("intVariableName", v.getId());
            startActivity(intent);

        }
        });

        Button sin= (Button)getActivity().findViewById(R.id.sinButton);
        sin.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View v)
        {

            Intent intent = new Intent(getActivity(), MapsActivity.class);
            intent.putExtra("intVariableName", v.getId());
            startActivity(intent);
          
        }
        });

        Button dal= (Button)getActivity().findViewById(R.id.dalButton);
        dal.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View v)
        {

            Intent intent = new Intent(getActivity() , MapsActivity.class);
            intent.putExtra("intVariableName", v.getId());
            startActivity(intent);
           
        }
        });
    }


}
