package com.yichiuan.onelook.data;

import android.support.annotation.NonNull;

import com.yichiuan.onelook.data.remote.OneLookService;
import com.yichiuan.onelook.data.remote.model.OLResponse;

import io.reactivex.Observable;


public class DictionaryRepository {
    private OneLookService  oneLookService;

    public DictionaryRepository(@NonNull OneLookService oneLookService) {
        this.oneLookService = oneLookService;
    }

    public Observable<OLResponse> fetchWordInfo(@NonNull String word) {
        return oneLookService.fetchWordInfo(word);
    }
}
