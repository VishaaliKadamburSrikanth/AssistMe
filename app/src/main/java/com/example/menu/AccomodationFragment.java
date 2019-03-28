package com.example.menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class AccomodationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {
        return inflater.inflate(R.layout.fragment_accomodation, container, false);
    }

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

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

    Button btn_off4 = (Button) getActivity().findViewById(R.id.Button2);
    btn_off4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.caprent.com/apartments-for-rent/halifax-ns/harbour-view/\n"));
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

