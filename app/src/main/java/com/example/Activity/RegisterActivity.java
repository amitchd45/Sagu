package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.connekma.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button mRegister_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mRegister_btn = (Button) findViewById(R.id.register_btn);
        mRegister_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_btn:{
                Intent register_btn_intent = new Intent(RegisterActivity.this, VerificationActivity.class);
                startActivity(register_btn_intent);
                break;
            }
        }
    }
}
