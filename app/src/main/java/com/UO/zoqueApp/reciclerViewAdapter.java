package com.UO.zoqueApp;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class reciclerViewAdapter extends RecyclerView.Adapter<reciclerViewAdapter.myViewHolder> {

    private Context mContext;
    private List<Course> mData;


    public reciclerViewAdapter(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.cardview_item_course,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, final int i) {
        myViewHolder.tvTitulo.setText(mData.get(i).getTitulo());
        myViewHolder.ivImagen.setImageResource(mData.get(i).getFoto());
        myViewHolder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,cursoDescripcion.class);
                intent.putExtra("titulo",mData.get(i).getTitulo());
                intent.putExtra("categoria",mData.get(i).getCategoria());
                intent.putExtra("descripcion",mData.get(i).getDescripcion());
                intent.putExtra("foto",mData.get(i).getFoto());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitulo;
        ImageView ivImagen;
        CardView cardview;
        public myViewHolder(View itemView){
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.textViewCardView);
            ivImagen = itemView.findViewById(R.id.imagenCardView);
            cardview = itemView.findViewById(R.id.cardViewManager);
        }
    }
}
