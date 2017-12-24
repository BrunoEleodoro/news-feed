package com.brunoeleodoro.org.recyclerviewtest.mvp;

import android.content.Context;

import com.brunoeleodoro.org.recyclerviewtest.Noticia;
import com.brunoeleodoro.org.recyclerviewtest.NoticiasAdapter;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by bruno on 23/12/17.
 */

public interface MVP {
    //https://newsapi.org/v2/everything?q=corrup%C3%A7%C3%A3o&from=2017-12-22&to=2017-12-22&sortBy=popularity&apiKey=d18e2e0587d44a689a04fcbfc4f17dae

    interface Model
    {
        public void receberNoticias(String tag);
    }

    interface Presenter
    {
        public void montarAdapter(JSONArray array);
        public void receberNoticias(String tag);

        public Context getContext();
        public void setView(MVP.View view);
    }

    interface View
    {
        public void montarLista(NoticiasAdapter adapter);
    }
}
