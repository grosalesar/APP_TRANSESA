package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Estaciones extends AppCompatActivity implements OnMapReadyCallback {
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estaciones);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.setTrafficEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-11.93812, -77.06953))
                .title("Repsol 1")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-11.95592, -77.06232))
                .title("Repsol 2"));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-11.98313, -77.08189))
                .title("Repsol 3"));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-11.98346, -77.05820))
                .title("Repsol 4"));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-12.04324, -77.04378))
                .title("Repsol 5"));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-12.07849, -77.06507))
                .title("Repsol 6"));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-11.98624, -77.08115))
                .title("Repsol 7"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-11.98624, -77.08115), 12));

    }

}