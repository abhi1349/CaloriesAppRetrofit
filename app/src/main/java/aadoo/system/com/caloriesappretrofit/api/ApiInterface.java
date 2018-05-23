package aadoo.system.com.caloriesappretrofit.api;

import java.util.List;

import aadoo.system.com.caloriesappretrofit.Retrofit.Calories;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("getcalories.php")
    Call<List<Calories>> getCaloriesInfo(@Query("item_type") String item_type);
}
