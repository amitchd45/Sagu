package com.example.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.connekma.R;

public class VerificationActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText otp1, otp2, otp3, otp4;
    Button mSubmit_btn;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        mSubmit_btn = (Button) findViewById(R.id.varification_submit_btn);
        mSubmit_btn.setOnClickListener(this);

        otp1 = findViewById(R.id.otp1);
        otp1.requestFocus();
        otp1.setShowSoftInputOnFocus(true);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);

        OTPCode();

    }

    private void OTPCode() {

        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 1) {
                    otp2.requestFocus();
                    otp1.setElevation(1);
                } else if (s.length() == 0) {

                }

            }
        });

        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 1) {
                    otp3.requestFocus();
                    otp2.setElevation(1);
                } else if (s.length() == 0) {

                    otp1.requestFocus();
                }

            }
        });

        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 1) {
                    otp4.requestFocus();
                    otp3.setElevation(1);
                } else if (s.length() == 0) {
                    otp2.requestFocus();
                }

            }
        });

        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 1) {
                    otp4.setElevation(1);
                } else if (s.length() == 0) {
                    otp3.requestFocus();
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.varification_submit_btn:{
                Intent verification_intent = new Intent(VerificationActivity.this, CongratulationsActivity.class);
                startActivity(verification_intent);
                break;
            }
        }
    }
}
