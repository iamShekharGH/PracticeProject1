package com.iamshekhargh.thirteenconcepts.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.iamshekhargh.thirteenconcepts.R;
import com.iamshekhargh.thirteenconcepts.network.models.response.PostsResponse;
import com.iamshekhargh.thirteenconcepts.ui.adapter.PostsAdapter;
import com.iamshekhargh.thirteenconcepts.ui.viewmodels.MainActivityViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class RestfulServiceFragment extends Fragment {
    Button makeCallButton;
    TextView descriptionTV;
    RecyclerView rv;
    MainActivityViewModel viewModel;
    PostsAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;


    public RestfulServiceFragment() {
        // Required empty public constructor
    }

    public static RestfulServiceFragment newInstance() {
        return new RestfulServiceFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_restful_service, container, false);
        makeCallButton = v.findViewById(R.id.res_ser_frag_make_call);
        descriptionTV = v.findViewById(R.id.res_ser_frag_instructions);
        rv = v.findViewById(R.id.res_ser_frag_rv_response);
        swipeRefreshLayout = v.findViewById(R.id.res_ser_frag_swiperl);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new PostsAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);

        viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        viewModel.getPostsResponseList().observe(getViewLifecycleOwner(), new Observer<List<PostsResponse>>() {
            @Override
            public void onChanged(List<PostsResponse> postsResponses) {
                adapter.setPostsList(postsResponses);
            }
        });
        makeCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRequestForPosts();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(() -> {
            showSnackbar("Kya??");
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    private void showSnackbar(String message) {
        Snackbar s = Snackbar.make(rv, message, BaseTransientBottomBar.LENGTH_LONG);
        s.show();
    }

    private void getRequestForPosts() {
        viewModel.getPosts();
    }
}