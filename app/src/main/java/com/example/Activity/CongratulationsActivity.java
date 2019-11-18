package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.connekma.R;

public class CongratulationsActivity extends AppCompatActivity implements View.OnClickListener {

    Button mCongratulation_done_btn;
    ImageView mBack_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);

        mCongratulation_done_btn = (Button) findViewById(R.id.cong_down_btn);
        mBack_btn = (ImageView) findViewById(R.id.iv_cong_back);
        mBack_btn.setOnClickListener(this);
        mCongratulation_done_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cong_down_btn:{
                Intent cong_intent = new Intent(CongratulationsActivity.this, GoogleMapActivity.class);
                startActivity(cong_intent);
                break;
            }
            case R.id.iv_cong_back:{
                Intent back_intent = new Intent(CongratulationsActivity.this, VerificationActivity.class);
                startActivity(back_intent);
                break;
            }
        }
    }
}
