package com.yichiuan.onelook.data.remote;

import com.yichiuan.onelook.data.remote.model.OLResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface OneLookService {
    @GET("?xml=1")
    Observable<OLResponse> fetchWordInfo(@Query("w") String word);
}
