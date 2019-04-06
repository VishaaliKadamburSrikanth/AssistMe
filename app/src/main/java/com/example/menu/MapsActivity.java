package com.example.menu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener{

    private GoogleMap maps;
    private Location lastloc;
    private Marker currentLocMarker;
    private GoogleApiClient apiClient;
    private LocationRequest locReq;
    public static final int LOC_CODE = 99;
    double lat, lng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            checkLocationPermission();

        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case LOC_CODE:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) !=  PackageManager.PERMISSION_GRANTED)
                    {
                        if(apiClient == null)
                        {
                            bulidGoogleApiClient();
                        }
                        maps.setMyLocationEnabled(true);
                    }
                }
                else
                {
                    Toast.makeText(this,"Permission is denied by the user" , Toast.LENGTH_LONG).show();
                }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        maps = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            bulidGoogleApiClient();
            maps.setMyLocationEnabled(true);
        }

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        fetchLoc(intValue);
    }


    protected synchronized void bulidGoogleApiClient() {
        apiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        apiClient.connect();

    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
        lastloc = location;
        if(currentLocMarker != null)
        {
            currentLocMarker.remove();

        }

        LatLng latLng = new LatLng(location.getLatitude() , location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        currentLocMarker = maps.addMarker(markerOptions);
        maps.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        maps.animateCamera(CameraUpdateFactory.zoomBy(10));

        if(apiClient != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(apiClient,this);
        }
    }
//receiving location of nsid,sin and dal card office
    public void fetchLoc(int val) {
          switch (val) {
            case R.id.sinButton:
                maps.clear();
                LatLng sca = new LatLng(44.645742, -63.595918);
                maps.addMarker(new MarkerOptions().position(sca)
                        .title("Service Canada"));
                maps.moveCamera(CameraUpdateFactory.newLatLng(sca));
                maps.animateCamera(CameraUpdateFactory.zoomTo(10));

                break;
            case R.id.nsidButton:
                maps.clear();
                LatLng ans = new LatLng(44.638566, -63.672329);
                maps.addMarker(new MarkerOptions().position(ans)
                        .title("Access Nova Scotia"));
                maps.moveCamera(CameraUpdateFactory.newLatLng(ans));
                maps.animateCamera(CameraUpdateFactory.zoomTo(10));
                break;
            case R.id.dalButton :
                maps.clear();
                LatLng dal = new LatLng(44.6390086,-63.5930778);
                maps.addMarker(new MarkerOptions().position(dal)
                        .title("Dal Card Office"));
                maps.moveCamera(CameraUpdateFactory.newLatLng(dal));
                maps.animateCamera(CameraUpdateFactory.zoomTo(10));
                break;

        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        locReq = new LocationRequest();
        locReq.setInterval(100);
        locReq.setFastestInterval(1000);
        locReq.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(apiClient, locReq, this);
        }
    }


    public boolean checkLocationPermission()
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)  != PackageManager.PERMISSION_GRANTED )
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION }, LOC_CODE);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION }, LOC_CODE);
            }
            return false;

        }
        else
            return true;
    }


    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }
}