package com.hskdeveloper.assigment;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("dummy/EmployeeDetails.json")
    Call<JsonResponse> getData();
}
