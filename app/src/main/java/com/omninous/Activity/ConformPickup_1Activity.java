package com.omninous.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.omninous.connekma.R;

public class ConformPickup_1Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView btn_back;
    Button mConform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conform_pickup_1);

        btn_back = findViewById(R.id.back_arrow);
        mConform = (Button) findViewById(R.id.btn_conform_pickup);
        btn_back.setOnClickListener(this);
        mConform.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_arrow:
                Intent intent = new Intent(ConformPickup_1Activity.this, GoogleMapActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_conform_pickup:
                Intent intent1 = new Intent(ConformPickup_1Activity.this, Payment_1Activity.class);
                startActivity(intent1);
                break;
        }

    }
}

