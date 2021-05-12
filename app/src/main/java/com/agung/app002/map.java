package com.agung.app002;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

public class map extends Fragment {

    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment supportMapFragment =(SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.Mps);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull @NotNull GoogleMap googleMap) {
                googleMap.setOnMapClickListener(latLng -> {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.title(latLng.latitude+"':"+latLng.longitude);
                    googleMap.clear();
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                            latLng, 10
                    ));
                    googleMap.addMarker(markerOptions);
                });
            }
        });




        return view;
    }
}