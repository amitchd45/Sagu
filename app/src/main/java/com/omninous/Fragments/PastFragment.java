package com.omninous.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omninous.Adapters.TripsAdapter;
import com.omninous.Models.TripModel;
import com.omninous.Utils.TripsNoteImformation;
import com.omninous.connekma.R;

import java.util.ArrayList;

public class PastFragment extends Fragment {

    RecyclerView mRecyclerView1;
    ArrayList<TripModel> tripModels;
    TripsAdapter tripsAdapter;



    public PastFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_past, container, false);

        mRecyclerView1=(RecyclerView) view.findViewById(R.id.recyclerView1);

        tripModels = new ArrayList<>();
        for (int i = 0; i< TripsNoteImformation.car_Name.length; i++){
            TripModel tripModel = new TripModel(TripsNoteImformation.date[i],TripsNoteImformation.prices[i],
                    TripsNoteImformation.car_Name[i],TripsNoteImformation.payment[i]);

            tripModels.add(tripModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        mRecyclerView1.setLayoutManager(layoutManager);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        TripsAdapter tripsAdapter = new TripsAdapter(tripModels, getContext(), new TripsAdapter.Select() {
            @Override
            public void Choose(int position) {

            }
        });
        mRecyclerView1.setAdapter(tripsAdapter);

        return view;

    }

}
