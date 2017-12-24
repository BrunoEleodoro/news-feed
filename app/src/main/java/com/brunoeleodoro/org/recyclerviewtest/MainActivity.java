package com.brunoeleodoro.org.recyclerviewtest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brunoeleodoro.org.recyclerviewtest.mvp.MVP;
import com.brunoeleodoro.org.recyclerviewtest.mvp.Presenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MVP.View {
    RecyclerView recyclerView;
    private MVP.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter();
        presenter.setView(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_layour_recycler);

        presenter.receberNoticias("");
    }

    @Override
    public void montarLista(NoticiasAdapter adapter) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }



}
