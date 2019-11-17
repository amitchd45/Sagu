package com.example.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.connekma.R;

public class FindingRideActivity extends AppCompatActivity implements View.OnClickListener {

    Button mRide_find_btn;
    final Context context=this;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_ride);

        mRide_find_btn = (Button) findViewById(R.id.ride_finding);
        mRide_find_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ride_finding:{
                showRideDialog();
                break;
            }
        }
    }

    private void showRideDialog() {
        dialog=new Dialog(context);
        dialog.setContentView(R.layout.find_ride_dialog);

        Button dialogButton_contact = (Button) dialog.findViewById(R.id.contact_btn);
        Button dialogButton_cancel = (Button) dialog.findViewById(R.id.cancel_btn);
        dialog.setCanceledOnTouchOutside(false);
        dialogButton_contact.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "contact...", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialogButton_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "cancel...", Toast.LENGTH_SHORT).show();
                CancelRideBookingDialog();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void CancelRideBookingDialog() {

        Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.booking_cancel_dialog);
        dialog.setCanceledOnTouchOutside(false);
        TextView mYes = (TextView) dialog.findViewById(R.id.yes_btn);
        TextView mNo = (TextView) dialog.findViewById(R.id.no_btn);
        ImageView mClose_dialog = (ImageView) dialog.findViewById(R.id.close_dialog);
        mClose_dialog.setOnClickListener(this);

        mYes.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                ReasonForCancelletionDialog();
                dialog.dismiss();
            }
        });
        mNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "close dialog", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });

        dialog.show();

    }

    private void ReasonForCancelletionDialog() {
        dialog=new Dialog(context);
        dialog.setContentView(R.layout.reason_for_cancellation);
        dialog.setCanceledOnTouchOutside(false);
        TextView mDone = (TextView) dialog.findViewById(R.id.done_1);
        TextView mCancel = (TextView) dialog.findViewById(R.id.cancel_1);
        mDone.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "done", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}
