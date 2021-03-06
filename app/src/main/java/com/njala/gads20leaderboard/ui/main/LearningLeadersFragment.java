package com.njala.gads20leaderboard.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.njala.gads20leaderboard.R;
import com.njala.gads20leaderboard.adapters.TopLearnerAdapter;
import com.njala.gads20leaderboard.apis.ApiService;
import com.njala.gads20leaderboard.apis.RetrofitClientInstance;
import com.njala.gads20leaderboard.models.TopLearner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeadersFragment extends Fragment {
    private ApiService mApiService;
    private View mRoot;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        mApiService = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
        Call<List<TopLearner>> topLearnerCall = mApiService.getTopLearnersList();

        topLearnerCall.enqueue(new Callback<List<TopLearner>>() {
            @Override
            public void onResponse(Call<List<TopLearner>> call, Response<List<TopLearner>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<TopLearner>> call, Throwable t) {
                Log.d("Error", "No Response");

            }
        });

        return mRoot;
    }

    private void generateDataList(List<TopLearner> body) {
        RecyclerView recyclerView = mRoot.findViewById(R.id.rv_top_learners);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TopLearnerAdapter adapter = new TopLearnerAdapter(getContext(), body);
        recyclerView.setAdapter(adapter);

    }
}