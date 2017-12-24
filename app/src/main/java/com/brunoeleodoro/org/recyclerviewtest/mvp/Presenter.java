package com.brunoeleodoro.org.recyclerviewtest.mvp;

import android.content.Context;
import android.util.Log;

import com.brunoeleodoro.org.recyclerviewtest.Noticia;
import com.brunoeleodoro.org.recyclerviewtest.NoticiasAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 23/12/17.
 */

public class Presenter implements MVP.Presenter {
    private MVP.View view;
    private MVP.Model model;

    public Presenter()
    {
        model = new ModelMVP(this);
    }

    @Override
    public void montarAdapter(JSONArray array) {
        int i = 0;
        List<Noticia> noticias = new ArrayList<>();
        try
        {
            while(i < array.length())
            {
                JSONObject object = array.getJSONObject(i);
                String descricao = object.getString("description");

                int limite = descricao.length();
                if(limite < 50)
                {
                    limite = descricao.length();
                }
                else
                {
                    limite = 50;
                }

                Noticia noticia = new Noticia(
                        object.getString("author"),
                        object.getString("author"),
                        object.getString("title"),
                        descricao.substring(0,limite),
                        object.getString("url"),
                        object.getString("urlToImage"),
                        object.getString("publishedAt")
                );

                noticias.add(noticia);

                if(i == 10)
                {
                    break;
                }
                i++;
            }
        }
        catch (Exception e)
        {
            Log.i("Script","erro montarAdapter="+e);
        }

        NoticiasAdapter adapter = new NoticiasAdapter(getContext(),noticias);

        view.montarLista(adapter);
    }

    @Override
    public void setView(MVP.View view) {
        this.view = view;
    }

    @Override
    public void receberNoticias(String tag) {
        if(tag.equals(""))
        {
            tag = "Tecnologia";
        }
        model.receberNoticias(tag);
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }
}
