package com.omninous.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.omninous.connekma.R;

public class SwitchRiderActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SwitchRiderActivity";


    Context context = this;
    Dialog dialog;
    ImageView mSwitch_user,btn_back;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_rider);

        mSwitch_user = (ImageView) findViewById(R.id.switch_rider);
        btn_back = findViewById(R.id.back_arrow);
        btn_back.setOnClickListener(this);
        mText = (TextView) findViewById(R.id.for_me);

        mText.setOnClickListener(view -> {

            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.switch_rider_dialog_box);

            Window window = dialog.getWindow();

//            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            window.setGravity(Gravity.TOP | Gravity.RIGHT);
            dialog.setTitle("switch user");
            dialog.setCancelable(true);



            dialog.show();

        });



//        mText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                PopupMenu popupMenu = new PopupMenu(SwitchRiderActivity.this,view);
//                popupMenu.getMenuInflater().inflate(R.menu.rider_menu,popupMenu.getMenu());
//
//                Object menuHelper;
//                Class[] argTypes;
//                try{
//                    Field mMenuHelper = PopupMenu.class.getDeclaredField("mPopup");
//                    mMenuHelper.setAccessible(true);
//                    menuHelper = mMenuHelper.get(popupMenu);
//                    argTypes = new Class[]{
//                            boolean.class
//                    };
//                    menuHelper.getClass().getDeclaredMethod("setForceShowIcon",argTypes).invoke(menuHelper,true);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
//
//                    popupMenu.show();
//                    return;
//                }
//
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//
//                        switch (menuItem.getItemId()){
//                            case R.id.me:
//                                Toast.makeText(context, "me", Toast.LENGTH_SHORT).show();
//                                return true;
//
//                        }
//
//                        switch (menuItem.getItemId()){
//                            case R.id.riding:
//                                Toast.makeText(context, "riding", Toast.LENGTH_SHORT).show();
//                                return true;
//
//                        }
//
//                        return true;
//                    }
//                });
//                popupMenu.show();
//            }
//        });



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_arrow:{
                Intent intent = new Intent(SwitchRiderActivity.this,ConformPickupActivity.class);
                startActivity(intent);
                break;
            }
        }

    }
}
