package aadoo.system.com.caloriesappretrofit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import aadoo.system.com.caloriesappretrofit.api.ApiClient;
import aadoo.system.com.caloriesappretrofit.api.ApiInterface;
import aadoo.system.com.caloriesappretrofit.Retrofit.Calories;
import aadoo.system.com.caloriesappretrofit.R;
import aadoo.system.com.caloriesappretrofit.Retrofit.RecyclerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Calories> calories;
    private RecyclerAdapter adapter;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        if(getIntent().getExtras()!=null)
        {
            String type = getIntent().getExtras().getString("type");
            fetchInformation(type);
        }
    }

    public void fetchInformation(String type)
    {
        apiInterface = ApiClient.getApiCLient().create(ApiInterface.class);

        Call<List<Calories>> call = apiInterface.getCaloriesInfo(type);

        call.enqueue(new Callback<List<Calories>>() {
            @Override
            public void onResponse(Call<List<Calories>> call, Response<List<Calories>> response) {

                calories = response.body();
                adapter = new RecyclerAdapter(calories,ListActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Calories>> call, Throwable t) {

            }
        });
    }
}
