package com.iamshekhargh.thirteenconcepts.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2021
 * at 2:26 AM.
 */
public abstract class CustomCallback<T> implements Callback<T> {

    public abstract void onDataArrived(T t);

    public abstract void onError(String error);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onDataArrived(response.body());

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError("onFailure\t:" + t.toString());
        t.printStackTrace();

    }

}
