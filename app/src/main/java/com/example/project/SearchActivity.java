package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private List<Furniture> fList = new ArrayList<>();
    private Button searchbt;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    EditText fn;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference bbsRef = database.getReference("furniture");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search2);

        image1 = findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);
        image3 = findViewById(R.id.image_3);
        image4 = findViewById(R.id.image_4);
        image5 = findViewById(R.id.image_5);
        searchbt = (Button) findViewById(R.id.searchbt);
        fn = (EditText) findViewById(R.id.furnitureName);
        searchbt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                database.getReference().child(String.valueOf(fn.getText())).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        fList.clear();
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            Furniture f = snapshot.getValue(Furniture.class);
                            fList.add(f);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
                );
                int i=1;
                for(Furniture f : fList){
                    String imageUrl = f.productImage;
                    String name = "image"+i;
                }

            }
        });

        String imageUrl = "https://static.coupangcdn.com/image/vendor_inventory/images/2017/10/26/11/7/6bea1914-eae6-46fb-9b46-75893960fffd.jpg";
        Glide.with(this).load(imageUrl).into(image1);
        imageUrl = "https://static.coupangcdn.com/image/vendor_inventory/images/2018/04/20/9/7/3d339729-5ef1-4362-b1b7-17aebd54cb46.jpg";
        Glide.with(this).load(imageUrl).into(image2);
        imageUrl = "https://static.coupangcdn.com/image/vendor_inventory/2ae0/3ec1f0e0145ad80d9492b9732a563fc070da58ab60809b4eceabbad6abfc.jpg";
        Glide.with(this).load(imageUrl).into(image3);
        imageUrl = "https://static.coupangcdn.com/image/vendor_inventory/7cc8/f10c49a8c093a1f06afac3c1435e412ad58a1c192bddacdd58c3672232fa.jpg";
        Glide.with(this).load(imageUrl).into(image4);
        imageUrl = "https://static.coupangcdn.com/image/vendor_inventory/35eb/25c599ba0474d424a50674c23b8cbe671f9482d7c689fb38d48d635bc9c2.jpg";
        Glide.with(this).load(imageUrl).into(image5);
    }
}
