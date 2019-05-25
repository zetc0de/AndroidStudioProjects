package com.example.elrahma.hero;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.CategoryViewHolder> {
    public ListHeroAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Heroes> getListHeroes() {
        return listHeroes;
    }

    public void setListHeroes(ArrayList<Heroes> listHeroes) {
        this.listHeroes = listHeroes;
    }

    private ArrayList<Heroes> listHeroes;
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemBaris = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero,parent,false);
        return new CategoryViewHolder(itemBaris);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.Nama.setText(getListHeroes().get(position).getNama());
        holder.Desk.setText(getListHeroes().get(position).getDeskripsi());

        Glide.with(context)
                .load(getListHeroes().get(position).getGambar())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.Gambar);
    }

    @Override
    public int getItemCount() {
        return getListHeroes().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView Nama;
        TextView Desk;
        ImageView Gambar;

            public CategoryViewHolder(View itemView) {
            super(itemView);
                Nama = itemView.findViewById(R.id.nama_hero);
                Desk = itemView.findViewById(R.id.deskripsi_hero);
                Gambar = itemView.findViewById(R.id.gambar_hero);
        }
    }
}
