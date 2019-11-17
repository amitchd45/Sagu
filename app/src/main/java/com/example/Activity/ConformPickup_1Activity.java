package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.connekma.R;

public class ConformPickup_1Activity extends AppCompatActivity {
    ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conform_pickup_1);

        btn_back = findViewById(R.id.back_arrow);
        btn_back.setOnClickListener(view -> {
            Intent intent = new Intent(ConformPickup_1Activity.this,GoogleMapActivity.class);
            startActivity(intent);
        });
    }
}
