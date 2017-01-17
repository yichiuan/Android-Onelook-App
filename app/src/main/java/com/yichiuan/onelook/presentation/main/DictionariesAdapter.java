package com.yichiuan.onelook.presentation.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yichiuan.onelook.R;
import com.yichiuan.onelook.data.remote.model.OLRes;
import com.yichiuan.onelook.presentation.dictionarydetail.DictionaryDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DictionariesAdapter extends RecyclerView.Adapter<DictionariesAdapter.ViewHolder> {

    private static final ArrayList<OLRes> NULL_RESOURCES = new ArrayList<>(0);

    private List<OLRes> dictionaries;
    private LayoutInflater inflater;
    private Context context;

    public DictionariesAdapter(Context context, List<OLRes> dictionaries) {

        if (dictionaries == null) {
            this.dictionaries = NULL_RESOURCES;
        } else {
            this.dictionaries = dictionaries;
        }

        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setResources(List<OLRes> resources) {
        if (resources == null) {
            dictionaries = NULL_RESOURCES;
        } else {
            dictionaries = resources;
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_dictionary, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OLRes resource = dictionaries.get(position);
        holder.dictionaryTextView.setText(resource.dictionary());
        holder.dictionaryTextView.setOnClickListener((v -> {
            Intent intent = new Intent(context, DictionaryDetailActivity.class);
            intent.putExtra("dictionary_url", resource.link());
            context.startActivity(intent);
        }));
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
