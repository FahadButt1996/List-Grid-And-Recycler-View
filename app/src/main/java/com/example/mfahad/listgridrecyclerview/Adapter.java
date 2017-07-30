package com.example.mfahad.listgridrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by M.FAHAD on 7/30/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder > {

    Context context;
    ArrayList<String> data;


    public Adapter(ArrayList<String> data , Context context){
        this.context = context;
        this.data=  data;
}

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView t1;
        public ViewHolder(View itemView){
            super(itemView);
//            Inflater inflater = new Inflater();
//            View v = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, null);
            t1 = (TextView)  itemView.findViewById(R.id.t3);
        }

    }
    // call when instance of ViewHolder class is created
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent
       ,false);
        return new ViewHolder(v);
    }

    //after calling the onCreatViewHolderr
    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.t1.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
