package com.omninous.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.omninous.connekma.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mActivity_Title;
    ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mActivity_Title = findViewById(R.id.header_text);
        mActivity_Title.setText("Contact Us");

        btn_back = findViewById(R.id.back_arrow);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_arrow:
                onBackPressed();
                break;
        }
    }
}
