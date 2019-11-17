package com.example.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Models.BookingModel;
import com.example.connekma.R;

import java.util.ArrayList;

public class MyBookingAdapter extends RecyclerView.Adapter<MyBookingAdapter.ViewHolder>{

    ArrayList<BookingModel> bookingModels;
    Context context;
    MyBookingAdapter.Select select;

    public static interface Select {
        void Choose(int position);
    }

    public MyBookingAdapter(ArrayList<BookingModel> bookingModels, Context context, Select select) {
        this.bookingModels = bookingModels;
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public MyBookingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookings_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBookingAdapter.ViewHolder holder, int position) {

        holder.mBooking_no.setText(bookingModels.get(position).getBooking_no());
        holder.mDateTime.setText(bookingModels.get(position).getDate());
        holder.mLocation.setText(bookingModels.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return bookingModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mBooking_no,mDateTime,mLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mBooking_no = (TextView) itemView.findViewById(R.id.booking_sr_no);
            mDateTime = (TextView) itemView.findViewById(R.id.booking_date);
            mLocation = (TextView) itemView.findViewById(R.id.booking_location);

        }
    }
}
