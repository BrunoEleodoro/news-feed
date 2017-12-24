package com.brunoeleodoro.org.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bruno on 23/12/17.
 */

public class NoticiasHolder extends RecyclerView.ViewHolder {

    public ImageView txt_img;
    public TextView txt_titulo;
    public TextView txt_desc;


    public NoticiasHolder(View view) {
        super(view);
        txt_img = (ImageView) view.findViewById(R.id.txt_img);
        txt_titulo = (TextView) view.findViewById(R.id.txt_titulo);
        txt_desc = (TextView) view.findViewById(R.id.txt_desc);
    }
}
