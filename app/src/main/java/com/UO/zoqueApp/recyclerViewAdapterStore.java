package com.UO.zoqueApp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class recyclerViewAdapterStore extends RecyclerView.Adapter<recyclerViewAdapterStore.myrecyclerviewHolder> {
    private Context mContext;
    private List<Course> mData;

    public recyclerViewAdapterStore(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myrecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardviewstore,viewGroup,false);
        return new myrecyclerviewHolder(view);
    }

    public void onBindViewHolder(@NonNull myrecyclerviewHolder myViewHolder, final int i) {
        myViewHolder.tvTitulo.setText(mData.get(i).getTitulo());
        myViewHolder.ivImagen.setImageResource(mData.get(i).getFoto());
        myViewHolder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,storeConfirm.class);
                intent.putExtra("titulo",mData.get(i).getTitulo());
                intent.putExtra("categoria",mData.get(i).getCategoria());
                intent.putExtra("descripcion",mData.get(i).getDescripcion());
                intent.putExtra("foto",mData.get(i).getFoto());
                intent.putExtra("reward",mData.get(i).getReward());
                mContext.startActivity(intent);
            }
        });

    }
    public int getItemCount() {
        return mData.size();
    }

    public static class myrecyclerviewHolder extends RecyclerView.ViewHolder{

        TextView tvTitulo;
        ImageView ivImagen;
        CardView cardview;


        public myrecyclerviewHolder(View itemView){
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.textViewCardViewstore);
            ivImagen = itemView.findViewById(R.id.imagenCardViewstore);
            cardview = itemView.findViewById(R.id.cardViewManagerstore);
        }
    }
}
