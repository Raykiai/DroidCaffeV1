package com.example.mydroidcaffev1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;



public class PastriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastries);

        TextView pastriesTitle = findViewById(R.id.pastries_title);
        pastriesTitle.setText(getIntent().getStringExtra("pTitle"));

        TextView pastriesPrep = findViewById(R.id.pastries_prep);
        pastriesPrep.setText(getIntent().getStringExtra("pPrep"));


        TextView pastriesDescription = findViewById(R.id.pastries_description);
        pastriesDescription.setText(getIntent().getStringExtra("pDescription"));

        ImageView pastriesImage = findViewById(R.id.pastries_image);
        Glide.with(this).load(getIntent().getIntExtra("pImage", 0)).into(pastriesImage);

    }
}
