package com.iamshekhargh.thirteenconcepts.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iamshekhargh.thirteenconcepts.R;
import com.iamshekhargh.thirteenconcepts.network.models.response.PostsResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2021
 * at 3:33 PM.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    List<PostsResponse> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_post, parent, false);
        return new PostsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        holder.setupCard(postsList.get(position));
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setPostsList(List<PostsResponse> postsList) {
        this.postsList = postsList;
        notifyDataSetChanged();

    }

    class PostsViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView userId;
        TextView id;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cv_post_title);
            description = itemView.findViewById(R.id.cv_post_description);
            userId = itemView.findViewById(R.id.cv_post_userid);
            id = itemView.findViewById(R.id.cv_post_id);
        }

        private void setupCard(PostsResponse p) {
            title.setText(p.getTitle());
            description.setText(p.getBody());
            userId.setText(String.valueOf(p.getUserId()));
            id.setText(String.valueOf(p.getId()));
        }
    }
}
