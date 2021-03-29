package com.iamshekhargh.thirteenconcepts.ui.viewmodels;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.iamshekhargh.thirteenconcepts.network.ApiEndpointInterface;
import com.iamshekhargh.thirteenconcepts.network.CustomCallback;
import com.iamshekhargh.thirteenconcepts.network.RetrofitInstanceProvider;
import com.iamshekhargh.thirteenconcepts.network.models.response.PostsResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2021
 * at 3:08 PM.
 */
public class MainActivityViewModel extends AndroidViewModel {
    MutableLiveData<List<PostsResponse>> postsResponseList;
    ApiEndpointInterface apiEndpointInterface;
    private static final String TAG = "MainActivityViewModel";

    public LiveData<List<PostsResponse>> getPostsResponseList() {
        if (postsResponseList == null) {
            postsResponseList = new MutableLiveData<>();
        }
        return postsResponseList;
    }

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void getPosts() {
        apiEndpointInterface = RetrofitInstanceProvider.getInstance().create(ApiEndpointInterface.class);
        Call<List<PostsResponse>> c = apiEndpointInterface.getPosts();
        c.enqueue(new CustomCallback<List<PostsResponse>>() {
            @Override
            public void onDataArrived(List<PostsResponse> postsResponses) {
                postsResponseList.postValue(postsResponses);
                Toast.makeText(getApplication().getBaseContext(), "onDataArrived:hasObservers " + postsResponseList.hasObservers(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Log.i(TAG, "onError: " + error);
            }
        });
    }
}
