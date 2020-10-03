package com.example.mydroidcaffev1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class StoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);

        TextView storesTitle = findViewById(R.id.stores_title);
        storesTitle.setText(getIntent().getStringExtra("sTitle"));

        TextView storesPrep = findViewById(R.id.stores_prep);
        storesPrep.setText(getIntent().getStringExtra("sPrep"));

        TextView storesDescription = findViewById(R.id.stores_description);
        storesDescription.setText(getIntent().getStringExtra("sDescription"));

        ImageView storesImage = findViewById(R.id.stores_image);
        Glide.with(this).load(getIntent().getIntExtra("sImage", 0)).into(storesImage);


    }
}
