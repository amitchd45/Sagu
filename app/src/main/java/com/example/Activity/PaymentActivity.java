package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.connekma.R;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout mAdd_payment;
    TextView mActivity_Title;
    ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        mActivity_Title = (TextView) findViewById(R.id.header_text);
        mActivity_Title.setText("Payment Options");
        btn_back = findViewById(R.id.back_arrow);
        btn_back.setOnClickListener(this);

        mAdd_payment = findViewById(R.id.add_payment_layout);
        mAdd_payment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_payment_layout:{
                Intent add_payment_intent = new Intent(PaymentActivity.this,AddPaymentActivity.class);
                startActivity(add_payment_intent);
                break;
            }
            case R.id.back_arrow: {
                Intent intent = new Intent(PaymentActivity.this, GoogleMapActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
