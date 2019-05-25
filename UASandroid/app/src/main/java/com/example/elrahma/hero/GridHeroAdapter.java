package com.example.elrahma.hero;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<Heroes> listHeroes;
    private ArrayList<Heroes> getListHeroes() {
        return listHeroes;
    }
    public void setListHeroes(ArrayList<Heroes> listHeroes) {
        this.listHeroes = listHeroes;
    }
    public GridHeroAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemBaris = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hero,parent,false);
        return new GridViewHolder(itemBaris);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListHeroes().get(position).getGambar())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.gambar_hero);
    }

    @Override
    public int getItemCount() {
        return getListHeroes().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView gambar_hero;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar_hero = itemView.findViewById(R.id.gambar_hero);
        }
    }
}
