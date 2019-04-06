package com.example.menu;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class WeatherFragment extends Fragment {
    ActionBarDrawerToggle drawToggle;
    DrawerLayout drawLayout;
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {

        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    TextView cityName_TextView, desc_TextView, temp_TextView;
    String city, desc;
    int temp;
    LineChartView chartView;

    //Average temperature values taken from official website to depict in graph

    String[] monthValue = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    int[] maxTemp = {0, 0 , 4, 9, 14, 20, 23, 23, 19, 13, 8, 3};
    int[] minTemp = {-8, -10 , -4, 1, 6, 11, 14, 15, 12,6, 1, -4};


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        //adding back button in the action bar
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Weather");
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

        //Textviews
        cityName_TextView = getActivity().findViewById(R.id.cityName);
        desc_TextView = getActivity().findViewById(R.id.desc);
        temp_TextView = getActivity().findViewById(R.id.temperature);

        //get current weather data
        getWeatherData();

        //fetch history data
        getGraph();

    }

    public void getGraph()
    {

        chartView = getActivity().findViewById(R.id.chart);

        // Add values for max temp
        List max = new ArrayList();
        Line maxTempLine = new Line(max).setColor(Color.parseColor("#540B94"));
        for (int i = 0; i < maxTemp.length; i++) {
            max.add(new PointValue(i, maxTemp[i]));
        }

        // Add values for min temp
        List min = new ArrayList();
        Line minTempLine = new Line(min).setColor(Color.parseColor("#000000"));
        for (int i = 0; i < minTemp.length; i++) {
            min.add(new PointValue(i, minTemp[i]));
        }

        // Add values for month
        List months = new ArrayList();
        for (int i = 0; i < monthValue.length; i++) {
            months.add(i, new AxisValue(i).setLabel(monthValue[i]));
        }

        // Add lines
        List addList = new ArrayList();
        addList.add(maxTempLine);
        addList.add(minTempLine);

        // Populate lines in chart
        LineChartData chartData = new LineChartData();
        chartData.setLines(addList);

        // Populate x axis
        Axis Xaxis = new Axis();
        Xaxis.setValues(months);
        Xaxis.setTextColor(Color.parseColor("#000000"));
        chartData.setAxisXBottom(Xaxis);

        // Populate y axis
        Axis Yaxis = new Axis();
        Yaxis.setName("Temperature");
        Yaxis.setTextColor(Color.parseColor("#000000"));
        chartData.setAxisYLeft(Yaxis);

        // Render chart View
        chartView.setLineChartData(chartData);

    }

    public void getWeatherData()
    {

        // API call to open weather for fetching current weather of halifax
        String api_url = "https://api.openweathermap.org/data/2.5/weather?q=Halifax&appid=c201d09ff627c1ce09e63d130abf07db&units=metric";

        // Fetching the response and mapping
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, api_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try
                {
                    JSONObject main = response.getJSONObject("main");
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject object = weather.getJSONObject(0);

                    city = response.getString("name");
                    temp = main.getInt("temp");
                    desc = object.getString("main");

                    System.out.println(temp);
                    System.out.println(desc);

                    cityName_TextView.setText(city);
                    temp_TextView.setText(temp + "°C");
                    desc_TextView.setText(desc);

                }catch(JSONException e)
                {
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);

    }
}