package com.example.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.Adapters.MainAdapter;
import com.example.Models.MainModel;
import com.example.connekma.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ConformPickupActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView mRecyclerView;
    ArrayList<MainModel>mainModels;
    MainAdapter mainAdapter;
    int a=-1;
    Button mConformPickup;
    final Context context = this;
    ImageView mOpenSideNavigation;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conform_pickup);

        mOpenSideNavigation = findViewById(R.id.iv_navigation_deawer1);

        mOpenSideNavigation.setOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        drawerLayout = findViewById(R.id.drawer_layout2);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        navigationView.getMenu().getItem(0).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(1).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(2).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(4).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(4).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(5).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(6).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(7).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(8).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(9).setActionView(R.layout.menu_image);



        mConformPickup = (Button) findViewById(R.id.conform_pickup);
        mConformPickup.setOnClickListener(view -> {
            Intent intent = new Intent(ConformPickupActivity.this,SwitchRiderActivity.class);
            startActivity(intent);
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        Integer[] langLogo = {R.drawable.layer_3_1,R.drawable.vector_smart_objectjh_1,R.drawable.layer_3_1,R.drawable.layer_3_1};

        String[] langName = {"Saden","luxury","People Movers","Saden"};
        String[] langPrices = {"$45.00","$45.00","$45.00","$45.00"};

        mainModels = new ArrayList<>();
        for (int i=0;i<langLogo.length;i++){
            MainModel model = new MainModel(langLogo[i],langName[i],langPrices[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(ConformPickupActivity.this,LinearLayoutManager.HORIZONTAL,false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(mainModels, ConformPickupActivity.this, new MainAdapter.Select() {
            @Override
            public void Choose(int position) {
                if (position!=-1){

                    Intent intent = new Intent(ConformPickupActivity.this,FindingRideActivity.class);
                    startActivity(intent);
                }

            }
        });


        mRecyclerView.setAdapter(mainAdapter);



    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_profile: {

                Intent profile_intent = new Intent(ConformPickupActivity.this, MyProfileActivity.class);
                startActivity(profile_intent);
                break;
            }
            case R.id.nav_trips: {
                Intent trips_intent = new Intent(ConformPickupActivity.this, TripsActivity.class);
                startActivity(trips_intent);
                break;
            }
            case R.id.nav_payment: {
                Intent payment_intent = new Intent(ConformPickupActivity.this, PaymentActivity.class);
                startActivity(payment_intent);
                break;
            }

            case R.id.nav_booking: {
                Intent bookings_intent = new Intent(ConformPickupActivity.this, MyBookingsActivity.class);
                startActivity(bookings_intent);
                break;
            }

            case R.id.nav_invite_friend: {
                Intent invite_intent = new Intent(ConformPickupActivity.this, InviteFriendsActivity.class);
                startActivity(invite_intent);
                break;
            }

            case R.id.nav_setting: {
                Intent settings_intent = new Intent(ConformPickupActivity.this, SettingsActivity.class);
                startActivity(settings_intent);
                break;
            }

            case R.id.nav_contact: {
                Intent contact_intent = new Intent(ConformPickupActivity.this, ContactActivity.class);
                startActivity(contact_intent);
                break;
            }

            case R.id.nav_emergency: {
                showDialogBox();
                break;
            }

            case R.id.nav_help: {
                Intent help_intent = new Intent(ConformPickupActivity.this, HelpActivity.class);
                startActivity(help_intent);
                break;
            }

            case R.id.nav_logout: {
                Toast.makeText(context, "Logout ...", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private void showDialogBox() {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog);

        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        ImageView dialogButton = (ImageView) dialog.findViewById(R.id.make_call);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                makeCall();
                Toast.makeText(context, "callCheck", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void makeCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + 198));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }


    @Override
    public void onBackPressed() {

        drawerLayout = findViewById(R.id.drawer_layout2);

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }

    }
}
