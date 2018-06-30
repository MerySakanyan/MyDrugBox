package com.example.mery.drugbox;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/pharmacy/data/pharm_drag.json")

    Call<List<DrugList>> getUsersList();
}
