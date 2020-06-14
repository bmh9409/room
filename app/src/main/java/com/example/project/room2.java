package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class room2 extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);


        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.camera:
                        setFrag(0);
                        break;
                    case R.id.favorite:
                        setFrag(1);
                        Toast.makeText(getApplicationContext(), "관심사로 등록되었습니다", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nearby:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });

        setFrag(0); //첫번째 프래그먼트를 어떻게 정해 줄지

    }
//프레그먼트 교체
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.commit();
                break;
            case 1:
                ft.commit();
                break;
            case 2:
                ft.commit();
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_maps, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_0:
                Intent i = new Intent(room2.this, MapsActivity.class);
                startActivity(i);
                //버튼을 만들어서 최근으로 돌가아면 좋을듯
                LatLng cham = new LatLng(37.301990, 127.039666);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(cham));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
                break;
            case R.id.menu_1:
                Intent i1 = new Intent(room2.this, room2.class);
                startActivity(i1);
                break;
            case R.id.menu_2:
                Intent i2 = new Intent(room2.this, MainActivity.class);
                startActivity(i2);
                break;
        }
        return true;
    }
}
