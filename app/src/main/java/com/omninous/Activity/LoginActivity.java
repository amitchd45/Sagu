package com.omninous.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.omninous.connekma.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mRegister;
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mRegister = (TextView) findViewById(R.id.user_register);
        mLogin = (Button) findViewById(R.id.login_btn);
        mRegister.setOnClickListener(this);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn: {
                Intent register_intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register_intent);
                break;
            }
            case R.id.user_register: {
                Intent register_intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register_intent);
                break;
            }

        }
    }
}
