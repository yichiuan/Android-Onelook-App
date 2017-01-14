package com.yichiuan.onelook.presentation.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yichiuan.onelook.R;
import com.yichiuan.onelook.data.remote.model.OLRes;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DictionariesAdapter extends RecyclerView.Adapter<DictionariesAdapter.ViewHolder> {

    private List<OLRes> dictionaries;
    private LayoutInflater inflater;

    public DictionariesAdapter(Context context, List<OLRes> dictionaries) {
        this.dictionaries = dictionaries;
        inflater = LayoutInflater.from(context);
    }

    public void setResources(List<OLRes> resources) {
        dictionaries = resources;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_dictionary, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dictionaryTextView.setText(dictionaries.get(position).dictionary());
    }

    @Override
    public int getItemCount() {
        return dictionaries.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textview_dictionary)
        TextView dictionaryTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
