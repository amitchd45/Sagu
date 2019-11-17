package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.connekma.R;

public class Payment_1Activity extends AppCompatActivity implements View.OnClickListener {

    Button mAddPayment_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_1);

        mAddPayment_btn = (Button) findViewById(R.id.add_payment_btn);
        mAddPayment_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_payment_btn:{
                Intent intent = new Intent(Payment_1Activity.this,AddPasswordActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
