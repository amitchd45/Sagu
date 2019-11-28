package com.omninous.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.omninous.Adapters.CustomAdapter;
import com.omninous.Models.CustomItem;
import com.omninous.connekma.R;

import java.util.ArrayList;

public class AddPaymentActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView mActivity_Title;
    ImageView btn_back;

    Spinner mSpinner;
    ArrayList<CustomItem> customList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpayment);

        mActivity_Title = findViewById(R.id.header_text);
        mActivity_Title.setText("Add Payment");
        btn_back = findViewById(R.id.back_arrow);
        btn_back.setOnClickListener(this);

        mSpinner = findViewById(R.id.custum_spinner);
        customList = getCustomList();
        CustomAdapter adapter = new CustomAdapter(this,customList);

        if (mSpinner != null) {
            mSpinner.setAdapter(adapter);
            mSpinner.setOnItemSelectedListener(this);
        }
    }

    private ArrayList<CustomItem> getCustomList() {
        customList = new ArrayList<>();
        customList.add(new CustomItem("Credit Card",R.drawable.card));
        customList.add(new CustomItem("Debit Card",R.drawable.card));

        return customList;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_arrow:
                onBackPressed();
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        CustomItem item = (CustomItem) adapterView.getSelectedItem();
        Toast.makeText(this, item.getSpinnerItemName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
