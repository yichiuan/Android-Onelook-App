package com.yichiuan.onelook.presentation.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;


public class HeaderRecyclerView extends RecyclerView {
    private View headerView;

    private HeaderAdapter headerAdapter;

    private AdapterDataObserver adapterDataObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            headerAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            headerAdapter.notifyItemRangeChanged(positionStart + HeaderAdapter.HEADER_SIZE, itemCount);
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            headerAdapter.notifyItemRangeChanged(positionStart + HeaderAdapter.HEADER_SIZE,
                    itemCount, payload);
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            headerAdapter.notifyItemRangeInserted(positionStart + HeaderAdapter.HEADER_SIZE, itemCount);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            headerAdapter.notifyItemRangeRemoved(positionStart + HeaderAdapter.HEADER_SIZE, itemCount);
        }
    };

    public HeaderRecyclerView(Context context) {
        super(context);
    }

    public HeaderRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HeaderRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void removeHeaderView() {
        if (headerView != null) {
            headerView = null;

            if (headerAdapter != null) {
                headerAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setHeaderView(View view) {
        headerView = view;
        if (headerAdapter != null) {
            headerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (headerAdapter != null) {
            headerAdapter.unregisterDataSetObserver(adapterDataObserver);
        }
        headerAdapter = new HeaderAdapter(adapter, headerView);
        headerAdapter.registerDataSetObserver(adapterDataObserver);
        super.setAdapter(headerAdapter);
    }
}
