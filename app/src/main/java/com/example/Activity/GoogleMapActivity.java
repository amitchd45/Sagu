package com.example.Activity;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.connekma.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class GoogleMapActivity extends AppCompatActivity implements OnMapReadyCallback,
        NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final String TAG = "MapDebug";
    private GoogleMap mGoogleMap;
    private final double CHD_LAT = 30.706587;
    private final double CHD_LNG = 76.762630;
    public static final int PERMISSION_REQUEST_CODE = 9001;
    private static final int PLAY_SERVICES_ERROR_CODE = 9002;
    public static final int GPS_REQUEST_CODE = 9003;
    public static final int DEFAULT_ZOOM = 15;

    private FusedLocationProviderClient mLocationClient;

    private EditText mAddress;
    ImageView mSchedule_set;
    private int mYear, mMonth, mDay, mHour, mMinute;


    final Context context = this;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        mSchedule_set = (ImageView) findViewById(R.id.schedule_btn);
        mSchedule_set.setOnClickListener(this);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        drawerLayout = findViewById(R.id.drawer_layout1);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //------------change navigation drawer icon button--------------

//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.vector_smart_object_1);

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


        mAddress = (EditText) findViewById(R.id.et_address);

        mLocationClient = new FusedLocationProviderClient(this);

        initGoogleMap();

        mAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GoogleMapActivity.this, ConformPickupActivity.class);
                startActivity(intent);
            }
        });


    }


    private void initGoogleMap() {

        if (isServicesOk()) {
            if (isGPSEnabled()) {
                if (checkLocationPermission()) {
                    Toast.makeText(this, "Ready to Map", Toast.LENGTH_SHORT).show();

                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.map_fragment_container);

                    supportMapFragment.getMapAsync(this);
                } else {
                    requestLocationPermission();
                }
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady: map is showing on the screen");

        mGoogleMap = googleMap;
        gotoLocation(CHD_LAT, CHD_LNG);


    }

    private void gotoLocation(double lat, double lng) {

        LatLng latLng = new LatLng(lat, lng);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, DEFAULT_ZOOM);

        mGoogleMap.moveCamera(cameraUpdate);
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }

    private boolean isGPSEnabled() {

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        boolean providerEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (providerEnabled) {
            return true;
        } else {

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("GPS Permissions")
                    .setMessage("GPS is required for this app to work. Please enable GPS.")
                    .setPositiveButton("Yes", ((dialogInterface, i) -> {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent, GPS_REQUEST_CODE);
                    }))
                    .setCancelable(false)
                    .show();

        }

        return false;
    }

    private boolean checkLocationPermission() {

        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
    }

    private boolean isServicesOk() {

        GoogleApiAvailability googleApi = GoogleApiAvailability.getInstance();

        int result = googleApi.isGooglePlayServicesAvailable(this);

        if (result == ConnectionResult.SUCCESS) {
            return true;
        } else if (googleApi.isUserResolvableError(result)) {
            Dialog dialog = googleApi.getErrorDialog(this, result, PLAY_SERVICES_ERROR_CODE, task ->
                    Toast.makeText(this, "Dialog is cancelled by User", Toast.LENGTH_SHORT).show());
            dialog.show();
        } else {
            Toast.makeText(this, "Play services are required by this application", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
            }
        }
    }

    private void getCurrentLocation() {

        mLocationClient.getLastLocation().addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                Location location = task.getResult();
                gotoLocation(location.getLatitude(), location.getLongitude());
            } else {
                Log.d(TAG, "getCurrentLocation: Error: " + task.getException().getMessage());
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GPS_REQUEST_CODE) {

            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            boolean providerEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if (providerEnabled) {
                Toast.makeText(this, "GPS is enabled", Toast.LENGTH_SHORT).show();

                SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map_fragment_container);

                supportMapFragment.getMapAsync(this);

            } else {
                Toast.makeText(this, "GPS not enabled. Unable to show user location", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void getLocation(View view) {
        getCurrentLocation();
    }

    @Override
    public boolean onNavigationItemSelected(@Nullable MenuItem menuItem) {


        switch (menuItem.getItemId()) {

            case R.id.nav_profile: {

                Intent profile_intent = new Intent(GoogleMapActivity.this, MyProfileActivity.class);
                startActivity(profile_intent);
                break;
            }
            case R.id.nav_trips: {
                Intent trips_intent = new Intent(GoogleMapActivity.this, TripsActivity.class);
                startActivity(trips_intent);
                break;
            }
            case R.id.nav_payment: {
                Intent payment_intent = new Intent(GoogleMapActivity.this, PaymentActivity.class);
                startActivity(payment_intent);
                break;
            }

            case R.id.nav_booking: {
                Intent bookings_intent = new Intent(GoogleMapActivity.this, MyBookingsActivity.class);
                startActivity(bookings_intent);
                break;
            }

            case R.id.nav_invite_friend: {
                Intent invite_intent = new Intent(GoogleMapActivity.this, InviteFriendsActivity.class);
                startActivity(invite_intent);
                break;
            }

            case R.id.nav_setting: {
                Intent settings_intent = new Intent(GoogleMapActivity.this, SettingsActivity.class);
                startActivity(settings_intent);
                break;
            }

            case R.id.nav_contact: {
                Intent contact_intent = new Intent(GoogleMapActivity.this, ContactActivity.class);
                startActivity(contact_intent);
                break;
            }

            case R.id.nav_emergency: {
                showDialogBox();
                break;
            }

            case R.id.nav_help: {
                Intent help_intent = new Intent(GoogleMapActivity.this, HelpActivity.class);
                startActivity(help_intent);
                break;
            }

            case R.id.nav_logout: {
                Intent logout_intent = new Intent(GoogleMapActivity.this, Payment_1Activity.class);
                startActivity(logout_intent);
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

        drawerLayout = findViewById(R.id.drawer_layout1);

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.schedule_btn: {
                ScheduleDialog();
                break;
            }
        }
    }

    private void ScheduleDialog() {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.schedule_ride_dialog);

        TextView mDatePicker, mTimePickFrom, mTimePickTo;
        Button mStartPickUp_btn;

        mDatePicker = (TextView) dialog.findViewById(R.id.et_datepicker1);
        mTimePickFrom = (TextView) dialog.findViewById(R.id.time_set_1);
        mTimePickTo = (TextView) dialog.findViewById(R.id.time_set_2);
        mStartPickUp_btn = (Button) dialog.findViewById(R.id.start_pickUp_btn);

        mStartPickUp_btn.setOnClickListener(view -> {
            Intent intent = new Intent(GoogleMapActivity.this, ConformPickup_1Activity.class);
            startActivity(intent);
            dialog.dismiss();
        });

        mDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(GoogleMapActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                Calendar cal = Calendar.getInstance();
                                cal.setTimeInMillis(0);
                                cal.set(year, monthOfYear, dayOfMonth, 0, 0, 0);
                                Date chosenDate = cal.getTime();



//                                mDatePicker.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                DateFormat df_full = DateFormat.getDateInstance(DateFormat.FULL);
                                String df_full_str = df_full.format(chosenDate);
                                mDatePicker.setText(mDatePicker.getText() + df_full_str);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        mTimePickFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(GoogleMapActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                String AM_PM;
                                if (hourOfDay >=0 && hourOfDay<12){
                                    AM_PM="AM";
                                }
                                else {
                                    AM_PM="PM";
                                }

                                mTimePickFrom.setText(hourOfDay + ":" + minute + " "+ AM_PM);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        mTimePickTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(GoogleMapActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                String AM_PM;
                                if (hourOfDay >=0 && hourOfDay<12){
                                    AM_PM="AM";
                                }
                                else {
                                    AM_PM="PM";
                                }

                                mTimePickTo.setText(hourOfDay + ":" + minute + " "+ AM_PM);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        dialog.show();

    }
}
