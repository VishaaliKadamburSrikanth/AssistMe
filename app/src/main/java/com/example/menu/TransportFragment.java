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


public class TransportFragment extends Fragment {
    private Button button;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance) {
        return inflater.inflate(R.layout.fragment_transport, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btn_off4 = (Button) getActivity().findViewById(R.id.Button4);
        btn_off4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://halifaxairporttcab.com/?gclid=CjwKCAjwm-fkBRBBEiwA966fZBPwkNY_ApifL-mmR6VoMuL0-HJj9OCbKtn1SKD9DzESDmhDpFmZVRoClLEQAvD_BwE\n"));
                getActivity().startActivity(i);

            }
        });

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel: 902_410_7415"));
        startActivity(callIntent);
            }





        }










