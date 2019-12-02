package br.ufc.crateus.localbus;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMaxZoomPreference(25);
        mMap.setMinZoomPreference(15);
        // Add a marker in Sydney and move the camera
        LatLng local = new LatLng(-5.1864371,-40.6452647);
        mMap.addMarker(new MarkerOptions().position(local).title("UFC - Campus Crateus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(local));

        LatLng ufc = new LatLng(-5.1864371,-40.6452647);
        mMap.addMarker(new MarkerOptions().position(ufc).title("UFC - Campus Crateus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ufc));
        LatLng romeu = new LatLng(-5.181988,-40.6653437);
        mMap.addMarker(new MarkerOptions().position(romeu).title("Rodoviaria dos pobres"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(romeu));
        LatLng pirulitos = new LatLng(-5.1774467,-40.6660563);
        mMap.addMarker(new MarkerOptions().position(pirulitos).title("Praça dos Pirulitos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pirulitos));
        LatLng matriz = new LatLng(-5.1743159,-40.669232);
        mMap.addMarker(new MarkerOptions().position(matriz).title("Praça da Matriz"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(matriz));
        LatLng sollo = new LatLng(-5.1896176,-40.6766762);
        mMap.addMarker(new MarkerOptions().position(sollo).title("Posto Sollo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sollo));
        LatLng amicao = new LatLng(-5.182212,-40.6715795);
        mMap.addMarker(new MarkerOptions().position(amicao).title("Amicão"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(amicao));
    }
    /*
    private void setMarker(LatLng local) {
        if (marker == null) {
            marker = mMap.addMarker(new MarkerOptions()
                    .position(local)
                    .title("Meu")
                    .icon(BitmapDescriptorFactory. defaultMarker(BitmapDescriptorFactory
                            .HUE_AZURE)));
        } else {
            marker.setPosition(local);
        }
        mMap.moveCamera(CameraUpdateFactory. newLatLng(local));
    }*/
}
