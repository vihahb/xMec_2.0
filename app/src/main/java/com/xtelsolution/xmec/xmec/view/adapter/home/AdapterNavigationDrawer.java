package com.xtelsolution.xmec.xmec.view.adapter.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xtelsolution.xmec.R;
import com.xtelsolution.xmec.xmec.model.entity.ItemNavigationDrawer;
import com.xtelsolution.xmec.xmec.view.activity.home.HomeView;

import java.util.ArrayList;

/**
 * Created by vivh on 24/08/2017.
 */

public class AdapterNavigationDrawer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ItemNavigationDrawer> arrayList;
    private HomeView homeView;
    private Context context;
    int selectedPosition=-1;

    private int ITEM = 1, LINE = 2;

    public AdapterNavigationDrawer(ArrayList<ItemNavigationDrawer> arrayList, HomeView view, Context context) {
        this.arrayList = arrayList;
        this.homeView = view;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_naviagtion, parent, false);
            return new ViewHolder(view);
        } else if (viewType == LINE) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_line, parent, false);
            return new LineHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if (holder instanceof ViewHolder){
            final ViewHolder itemHolder = (ViewHolder) holder;
            final ItemNavigationDrawer item = arrayList.get(position);
            if (item.getName() != null){
             itemHolder.tv_item_name.setText(item.getName());
            }

            if (item.getResource() != -1){
                itemHolder.ic_item.setImageResource(item.getResource());
            }
            itemHolder.initItemClick(position);
        }
    }



    @Override
    public int getItemViewType(int position) {
        if (arrayList.get(position).getType() == 0) {
            return ITEM;
        } else {
            return LINE;
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_root;
        private ImageView ic_item;
        private TextView tv_item_name;

        public ViewHolder(View itemView) {
            super(itemView);
            item_root = (LinearLayout) itemView.findViewById(R.id.item_root);
            ic_item = (ImageView) itemView.findViewById(R.id.ic_item);
            tv_item_name = (TextView) itemView.findViewById(R.id.tv_item_name);
        }

        public void initItemClick(final int position){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedPosition = position;
                    notifyDataSetChanged();
                    homeView.itemDrawerClick(view, position);
                }
            });
            if (selectedPosition==position){
                setItemClick(itemView);
            } else {
                setItemNonClick(itemView);
            }
        }

        private void setItemClick(View itemHolder) {
            itemView.setBackgroundColor(context.getResources().getColor(R.color.black_10));
            tv_item_name.setTextColor(context.getResources().getColor(R.color.black_80));
            switch (selectedPosition){
                case 0:
                    ic_item.setImageResource(R.mipmap.ic_selected_medical_report);
                    break;
                case 1:
                    ic_item.setImageResource(R.mipmap.ic_selected_news);
                    break;
                case 2:
                    ic_item.setImageResource(R.mipmap.ic_selected_find);
                    break;
                case 3:
                    ic_item.setImageResource(R.mipmap.ic_selected_find_drug);
                    break;
                case 4:
                    ic_item.setImageResource(R.mipmap.ic_selected_hospital);
                    break;
                case 6:
                    ic_item.setImageResource(R.mipmap.ic_selected_share);
                    break;
                case 7:
                    ic_item.setImageResource(R.mipmap.ic_selected_setting);
                    break;
                case 9:
                    ic_item.setImageResource(R.mipmap.ic_selected_logout);
                    break;
                default:
            }
        }

        private void setItemNonClick(View itemHolder) {
            itemView.setBackgroundColor(context.getResources().getColor(android.R.color.white));
            tv_item_name.setTextColor(context.getResources().getColor(R.color.black_60));
            int position = getAdapterPosition();
            switch (position){
                case 0:
                    ic_item.setImageResource(R.mipmap.ic_medical_report);
                    break;
                case 1:
                    ic_item.setImageResource(R.mipmap.ic_news);
                    break;
                case 2:
                    ic_item.setImageResource(R.mipmap.ic_find);
                    break;
                case 3:
                    ic_item.setImageResource(R.mipmap.ic_find_drug);
                    break;
                case 4:
                    ic_item.setImageResource(R.mipmap.ic_hospital);
                    break;
                case 6:
                    ic_item.setImageResource(R.mipmap.ic_share);
                    break;
                case 7:
                    ic_item.setImageResource(R.mipmap.ic_setting);
                    break;
                case 9:
                    ic_item.setImageResource(R.mipmap.ic_logout);
                    break;
                default:
            }
        }
    }

    private class LineHolder extends RecyclerView.ViewHolder {
        LinearLayout line;

        public LineHolder(View itemView) {
            super(itemView);
            line = itemView.findViewById(R.id.ln_line);
        }
    }

    public void refreshData(ArrayList<ItemNavigationDrawer> arrayList) {
        this.arrayList.clear();
        this.arrayList.addAll(arrayList);
        notifyDataSetChanged();
    }
}
