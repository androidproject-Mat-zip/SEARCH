package org.techtwon.searchactivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {


    OnMenuItemClickListener listener;

    ArrayList<Menu> items = new ArrayList<Menu>();
    Activity activity;


    public MenuAdapter(ArrayList<Menu> list,Activity activity){
        this.items = list;
        this.activity = activity;

    }

    public  void addItem(Menu item){
        items.add(item);
    }

    public void setItems(ArrayList<Menu> items){
        this.items = items;
    }

    public Menu getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Menu item){
        items.set(position,item);
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int ViewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.menu_item, viewGroup, false);

        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Menu item = items.get(position);
        viewHolder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnMenuItemClickListener listener){
        this.listener = listener;

    }

    public void  filterList(ArrayList<Menu> filteredList) {
        items = filteredList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView, final OnMenuItemClickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null){
                        listener.onItemClick(ViewHolder.this,v,position);
                    }
                }
            });
        }
        public void setItem(Menu item){
            textView.setText(item.getName());
            textView2.setText(item.getAdd());
        }

    }
}
