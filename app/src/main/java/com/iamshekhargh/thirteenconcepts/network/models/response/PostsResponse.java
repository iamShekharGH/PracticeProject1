package com.iamshekhargh.thirteenconcepts.network.models.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2021
 * at 3:01 AM.
 * {
 * "userId": 1,
 * "id": 2,
 * "title": "qui est esse",
 * "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
 * },
 */
public class PostsResponse {

    @SerializedName("userId")
    int userId;

    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("body")
    String body;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
