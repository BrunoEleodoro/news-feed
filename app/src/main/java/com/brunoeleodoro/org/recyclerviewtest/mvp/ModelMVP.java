package com.brunoeleodoro.org.recyclerviewtest.mvp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.brunoeleodoro.org.recyclerviewtest.Noticia;
import com.brunoeleodoro.org.recyclerviewtest.NoticiasAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bruno on 23/12/17.
 */

public class ModelMVP implements MVP.Model {
    private MVP.Presenter presenter;

    public ModelMVP(MVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void receberNoticias(String tag) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String data = formatter.format(new Date());

        RequestQueue queue = Volley.newRequestQueue(presenter.getContext());
        StringRequest request = new StringRequest(Request.Method.GET, "https://newsapi.org/v2/everything?q="+tag+"&from="+data+"&to="+data+"&sortBy=popularity&apiKey=d18e2e0587d44a689a04fcbfc4f17dae", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try
                {
                    JSONObject object = new JSONObject(s);
                    JSONArray array = object.getJSONArray("articles");

                    presenter.montarAdapter(array);
                }
                catch (Exception e)
                {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("Script","erro volley="+volleyError);
            }
        });
        queue.add(request);
    }
}
