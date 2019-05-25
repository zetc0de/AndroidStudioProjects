package com.example.elrahma.hero;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardHeroAdapter extends RecyclerView.Adapter<CardHeroAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Heroes> listHeroes;
    private ArrayList<Heroes> getListHeroes() {
        return listHeroes;
    }
    public void setListHeroes(ArrayList<Heroes> listHeroes) {
        this.listHeroes = listHeroes;
    }
    public CardHeroAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_hero, viewGroup, false);
        return new CardViewViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {
        Heroes p = getListHeroes().get(i);
        Glide.with(context)
                .load(p.getGambar())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.gambar_hero);

        cardViewViewHolder.nama_hero.setText(getListHeroes().get(i).getNama());
        cardViewViewHolder.deskripsi_hero.setText(getListHeroes().get(i).getDeskripsi());

//        cardViewViewHolder.nama_hero.setText(p.getNama());
//        cardViewViewHolder.deskripsi_hero.setText(p.getDeskripsi());
        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListHeroes().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListHeroes().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));
    }
    @Override
    public int getItemCount() {
        return getListHeroes().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView gambar_hero;
        TextView nama_hero, deskripsi_hero;
        Button btnFavorite, btnShare;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar_hero = itemView.findViewById(R.id.gambar_hero);
            nama_hero = itemView.findViewById(R.id.nama_hero);
            deskripsi_hero = itemView.findViewById(R.id.deskripsi_hero);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
