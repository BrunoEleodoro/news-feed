package com.brunoeleodoro.org.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 23/12/17.
 */

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasHolder> {
    List<Noticia> noticias = new ArrayList<>();
    Context context;
    public NoticiasAdapter(Context context,List<Noticia> noticias) {
        this.noticias = noticias;
        this.context = context;
    }

    @Override
    public NoticiasHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NoticiasHolder holder =new NoticiasHolder(inflater.inflate(R.layout.linha_noticia,parent,false));


        return holder;
    }

    @Override
    public void onBindViewHolder(NoticiasHolder holder, int position) {
        final Noticia noticia = noticias.get(position);

        Picasso.with(context).load(noticia.getImg()).resize(150,150).into(holder.txt_img);
        holder.txt_titulo.setText(noticia.getTitulo());
        holder.txt_desc.setText(noticia.getDescricao());

        holder.txt_titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(noticia.getUrl()));
                context.startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }
}
