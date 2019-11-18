package com.example.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.connekma.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class MyProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mActivity_Title;
    private ImageView btn_back, mImage,mProfileImage;
    Uri resultUri;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mActivity_Title = (TextView) findViewById(R.id.header_text);
        mActivity_Title.setText("Profile");

        btn_back = findViewById(R.id.back_arrow);
        btn_back.setOnClickListener(this);
        mImage = findViewById(R.id.pick_image1);
        mImage.setOnClickListener(this);
        mProfileImage = findViewById(R.id.profile_pic);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_arrow:
                onBackPressed();
//                Intent intent = new Intent(MyProfileActivity.this, GoogleMapActivity.class);
//                startActivity(intent);
                break;

            case R.id.pick_image1:
                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON);
                CropImage.activity().start(MyProfileActivity.this);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {

            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {

                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {

                    resultUri = result.getUri();
                    mProfileImage.setImageURI(resultUri);

                    Toast.makeText(this, "Image Uploade Successfully.", Toast.LENGTH_SHORT).show();

                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception erroe = result.getError();
                    Toast.makeText(this, "error,please try again.", Toast.LENGTH_SHORT).show();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
