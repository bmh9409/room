package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SCActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        image1 = findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);
        image3 = findViewById(R.id.image_3);
        image4 = findViewById(R.id.image_4);
        image5 = findViewById(R.id.image_5);
        image6 = findViewById(R.id.image_6);

        //String imageUrl = "https://www.ikea.com/kr/ko/images/products/hammarn-sofa-bed__0519027_PE641353_S5.JPG?f=xs";
       // Glide.with(this).load(imageUrl).into(image1);
       // imageUrl = "https://www.ikea.com/kr/ko/images/products/neiden-bed-frame__0749131_PE745500_S5.JPG?f=xs";
      //  Glide.with(this).load(imageUrl).into(image2);

    }
}
