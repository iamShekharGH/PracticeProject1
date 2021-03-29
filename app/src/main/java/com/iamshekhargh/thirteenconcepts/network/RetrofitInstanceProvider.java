package com.iamshekhargh.thirteenconcepts.network;

import com.iamshekhargh.thirteenconcepts.network.environment.EnvironmentProvider;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.iamshekhargh.thirteenconcepts.network.environment.EnvironmentEnum.STABLE;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2021
 * at 2:40 AM.
 */
public class RetrofitInstanceProvider {
    static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {

            HttpLoggingInterceptor h = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder b = new OkHttpClient.Builder();
            b.addInterceptor(h);

            retrofit = new Retrofit.Builder()
                    .baseUrl(new EnvironmentProvider().getEnvironment(STABLE))
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(b.build())
                    .build();

        }
        return retrofit;
    }
}
