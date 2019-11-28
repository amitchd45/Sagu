package com.omninous.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.omninous.connekma.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button mRegister_btn;
    ImageView mBack_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRegister_btn = findViewById(R.id.register_btn);
        mBack_btn = findViewById(R.id.iv_back_btn);
        mBack_btn.setOnClickListener(this);
        mRegister_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_btn: {
                Intent register_btn_intent = new Intent(RegisterActivity.this, VerificationActivity.class);
                startActivity(register_btn_intent);
                break;
            }
            case R.id.iv_back_btn: {
                Intent back_btn_intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(back_btn_intent);
                break;
            }
        }
    }
}
