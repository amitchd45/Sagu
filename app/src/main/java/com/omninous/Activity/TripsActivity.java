package com.omninous.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.omninous.Adapters.SectionsPagerAdapter;
import com.omninous.connekma.R;
import com.google.android.material.tabs.TabLayout;

public class TripsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private TabLayout mTablayout;

    TextView mActivity_Title;
    private ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);

        mActivity_Title = (TextView) findViewById(R.id.header_text);
        mActivity_Title.setText("Your Trips");

        btn_back = findViewById(R.id.back_arrow);
        btn_back.setOnClickListener(this);

        mViewPager = (ViewPager) findViewById(R.id.main_Tabpager);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mTablayout = (TabLayout) findViewById(R.id.main_tab);
        mTablayout.setupWithViewPager(mViewPager);
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
