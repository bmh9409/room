package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView btn_join;
    TextView btn_login;
    TextView btn_mypage;
    ImageView btn_map;
    ImageButton btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn_join = findViewById(R.id.btn_join);
        btn_login = findViewById(R.id.btn_login);
        btn_map = findViewById(R.id.btn_map);
        btn_search = findViewById(R.id.imageButton5);
        btn_mypage = findViewById(R.id.btn_mypage);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this,SearchActivity.class);
                MainActivity.this.startActivity(searchIntent);
            }
        });
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent joinIntent = new Intent(MainActivity.this, JoinActivity.class);
                MainActivity.this.startActivity(joinIntent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
                MainActivity.this.startActivity(loginIntent);
            }
        });
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(mapIntent);
            }

        });
        btn_mypage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent mpIntent = new Intent(MainActivity.this,FindActivity.class);
                MainActivity.this.startActivity(mpIntent);
            }
        });

    }
}
