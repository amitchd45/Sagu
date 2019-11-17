package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.Adapters.MainAdapter;
import com.example.Models.MainModel;
import com.example.connekma.R;

import java.util.ArrayList;

public class ConformPickupActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<MainModel>mainModels;
    MainAdapter mainAdapter;
    int a=-1;
    Button mConformPickup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conform_pickup);

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

            }
        });


        mRecyclerView.setAdapter(mainAdapter);



    }
}
