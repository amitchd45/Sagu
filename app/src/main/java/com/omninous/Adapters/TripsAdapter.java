package com.omninous.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omninous.Models.TripModel;
import com.omninous.connekma.R;

import java.util.ArrayList;

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.ViewHolder> {


    ArrayList<TripModel> tripModels;
    Context context;
    TripsAdapter.Select select;

    public static interface Select {
        void Choose(int position);
    }

    public TripsAdapter(ArrayList<TripModel> tripModels, Context context, Select select) {
        this.tripModels = tripModels;
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trips_item,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mDate.setText(tripModels.get(position).getDate());
        holder.mPrice.setText(tripModels.get(position).getPrices());
        holder.mName.setText(tripModels.get(position).getCar_Name());
        holder.mMethod.setText(tripModels.get(position).getPayment());

    }

    @Override
    public int getItemCount() {
        return tripModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mDate,mPrice,mName,mMethod;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mDate = (TextView) itemView.findViewById(R.id.date);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mName = (TextView) itemView.findViewById(R.id.car_name1);
            mMethod = (TextView) itemView.findViewById(R.id.method);
        }
    }
}
