package com.example.pizza_loop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Location extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.google_map);
            mapFragment.getMapAsync(this );
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        LatLng Meesalai=new LatLng(9.671588, 80.187349);
        MarkerOptions options=(new MarkerOptions().position(Meesalai).title("Meesalai branch"));
        map.addMarker(options);
        map.moveCamera(CameraUpdateFactory.newLatLng(Meesalai));

    }
}
