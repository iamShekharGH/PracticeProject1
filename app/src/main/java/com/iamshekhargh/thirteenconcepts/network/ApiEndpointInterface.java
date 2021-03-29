package com.iamshekhargh.thirteenconcepts.network;

import com.iamshekhargh.thirteenconcepts.network.models.response.PostsResponse;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2021
 * at 2:26 AM.
 */
public interface ApiEndpointInterface {
    @GET("posts/")
    Call<List<PostsResponse>> getPosts();
}
