package com.yichiuan.onelook.data.remote;

import com.yichiuan.onelook.data.remote.model.OLResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface OneLookService {
    @GET("?xml=1")
    Observable<OLResponse> fetchWordInfo(@Query("w") String word);
}
