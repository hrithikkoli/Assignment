package com.hskdeveloper.assigment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView recyclerView;
    Adapter adapter;
    RetrofitInterface apiInterface;
    List<Model> list = new ArrayList<>();
    LinearLayoutManager  linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("EmployeeDummy");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.dark_grey)));
        fetchData();



    }
    public  void fetchData(){
        apiInterface = RetrofitInstance.getRetrofit().create(RetrofitInterface.class);
        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        apiInterface.getData().enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                JsonResponse jsonResponse = response.body();
                list = new ArrayList<>(Arrays.asList(jsonResponse.getEmployees()));
                adapter = new Adapter(MainActivity.this,list,MainActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapter);
                //  Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }



    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,Details.class);
        intent.putExtra("name",list.get(position).getName());
        intent.putExtra("salary",String.valueOf(list.get(position).getSalary()));
        intent.putExtra("age",String.valueOf(list.get(position).getAge()));
        startActivity(intent);
    }
}