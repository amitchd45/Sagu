package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.connekma.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mActivity_Title;
    ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mActivity_Title = (TextView) findViewById(R.id.header_text);
        mActivity_Title.setText("Contact Us");

        btn_back = findViewById(R.id.back_arrow);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_arrow:
                Intent intent = new Intent(ContactActivity.this, GoogleMapActivity.class);
                startActivity(intent);
                break;
        }
    }
}
