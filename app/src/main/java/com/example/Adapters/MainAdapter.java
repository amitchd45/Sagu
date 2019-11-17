package com.example.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Models.MainModel;
import com.example.connekma.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private OnItemClickListener mListener;
    int a=-1;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

    }

    ArrayList<MainModel>mainModels;
    Context context;
    Select select;

  public static interface Select {
        void Choose(int position);
    }

    public MainAdapter(ArrayList<MainModel> mainModels, Context context, Select select) {
        this.mainModels = mainModels;
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_1,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(mainModels.get(position).getLangLogo());
        holder.carName.setText(mainModels.get(position).getLangName());
        holder.carPrice.setText(mainModels.get(position).getLangPrices());

        if (a==position) {
            holder.mCard.setBackgroundResource(R.drawable.button_background);
            holder.carName.setTextColor(context.getResources().getColor(R.color.white));
            holder.carPrice.setTextColor(context.getResources().getColor(R.color.white));
//            holder.tv_carTime.setTextColor(context.getResources().getColor(R.color.white));
            holder.imageView.setBackgroundResource(R.color.white);

        }else {
            holder.mCard.setBackgroundResource(R.color.white);
            holder.carName.setTextColor(context.getResources().getColor(R.color.lightDark));
            holder.carPrice.setTextColor(context.getResources().getColor(R.color.lightDark));
//            holder.tv_carTime.setTextColor(context.getResources().getColor(R.color.white));
//            holder.imageView.setBackgroundResource(R.color.white);

        }

    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView carName;
        TextView carPrice;
        RelativeLayout relativeLayoutl;
        CardView mCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_View);
            carName = (TextView) itemView.findViewById(R.id.car_name);
            carPrice = (TextView) itemView.findViewById(R.id.car_price);
            mCard=itemView.findViewById(R.id.cardLay);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   select.Choose(getLayoutPosition());
                   a = getLayoutPosition();
                   notifyDataSetChanged();
                }
            });
        }
    }
}
