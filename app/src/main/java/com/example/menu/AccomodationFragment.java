package com.example.menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import java.util.zip.Inflater;

public class AccomodationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {
        return inflater.inflate(R.layout.fragment_accomodation, container, false);
    }
    public void open(View view)
    {
        Intent browserIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kijiji.ca/\n"));
        startActivity(browserIntent);

        Intent browserIntent1 =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.airbnb.ca/\n"));
        startActivity(browserIntent1);
    }

}
