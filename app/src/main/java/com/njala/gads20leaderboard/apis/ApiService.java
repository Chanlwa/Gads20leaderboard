package com.njala.gads20leaderboard.apis;

import com.njala.gads20leaderboard.models.IqLeader;
import com.njala.gads20leaderboard.models.TopLearner;

import java.util.List;

import retrofit2.Call;
;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/api/hours")
    Call<List<TopLearner>> getTopLearnersList();


    @GET("/api/skilliq")
    Call<List<IqLeader>> getIqLeadersList();

}
