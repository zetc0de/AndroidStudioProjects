package com.example.elrahma.hero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Hero extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Heroes> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero);

        rvHeroes = findViewById(R.id.rv_kategori);
        rvHeroes.setHasFixedSize(true);

        list.addAll(HeroesData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(this);
        listHeroAdapter.setListHeroes(list);
        rvHeroes.setAdapter(listHeroAdapter);
    }

    private void showRecyclerGrid(){
        rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(this);
        gridHeroAdapter.setListHeroes(list);
        rvHeroes.setAdapter(gridHeroAdapter);
    }

    private void showRecyclerCardView(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        CardHeroAdapter cardHeroAdapter = new CardHeroAdapter(this);
        cardHeroAdapter.setListHeroes(list);
        rvHeroes.setAdapter(cardHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
