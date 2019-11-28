package com.omninous.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.omninous.Adapters.MyBookingAdapter;
import com.omninous.Models.BookingModel;
import com.omninous.Utils.MyBookingImformation;
import com.omninous.connekma.R;

import java.util.ArrayList;

public class MyBookingsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mActivity_Title;
    ImageView btn_back;

    RecyclerView mRecyclerView;
    ArrayList<BookingModel> bookingModels;
    MyBookingAdapter myBookingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);

        mRecyclerView =(RecyclerView) findViewById(R.id.booking_recyclerView);

        mActivity_Title = (TextView) findViewById(R.id.header_text);
        mActivity_Title.setText("My Bookings");

        btn_back = findViewById(R.id.back_arrow);
        btn_back.setOnClickListener(this);


        bookingModels = new ArrayList<>();
        for (int i = 0; i< MyBookingImformation.booking_no.length; i++){
            BookingModel bookingModel = new BookingModel(MyBookingImformation.date[i],MyBookingImformation.booking_no[i],
                    MyBookingImformation.location[i]);

            bookingModels.add(bookingModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(MyBookingsActivity.this,LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        MyBookingAdapter myBookingAdapter = new MyBookingAdapter(bookingModels, MyBookingsActivity.this, new MyBookingAdapter.Select() {
            @Override
            public void Choose(int position) {

            }
        });

        mRecyclerView.setAdapter(myBookingAdapter);

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
