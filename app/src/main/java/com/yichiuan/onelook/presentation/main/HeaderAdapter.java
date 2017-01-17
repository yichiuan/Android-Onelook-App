package com.yichiuan.onelook.presentation.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class HeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER_ITEM_TYPE = Integer.MAX_VALUE - 1;
    public static final int HEADER_SIZE = 1;

    private View headerView;
    private RecyclerView.Adapter innerAdapter;

    public HeaderAdapter(RecyclerView.Adapter innerAdapter, View headerView) {
        this.innerAdapter = innerAdapter;
        this.headerView = headerView;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)) {
            return HEADER_ITEM_TYPE;
        }
        else {
            return innerAdapter.getItemViewType(position - HEADER_SIZE);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER_ITEM_TYPE:
                return new HeaderViewHolder(headerView);
            default:
                return innerAdapter.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (innerAdapter.getItemCount() == 0) return;
        if (!isHeaderView(position)) {
            innerAdapter.onBindViewHolder(holder, position - HEADER_SIZE);
        }
    }

    private boolean isHeaderView(int position) {
        return position < HEADER_SIZE;
    }

    @Override
    public int getItemCount() {
        return innerAdapter.getItemCount() + HEADER_SIZE;
    }

    public void registerDataSetObserver(RecyclerView.AdapterDataObserver dataObserver) {
        if (innerAdapter != null) {
            innerAdapter.registerAdapterDataObserver(dataObserver);
        }
    }

    public void unregisterDataSetObserver(RecyclerView.AdapterDataObserver dataObserver) {
        if (innerAdapter != null) {
            innerAdapter.unregisterAdapterDataObserver(dataObserver);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
