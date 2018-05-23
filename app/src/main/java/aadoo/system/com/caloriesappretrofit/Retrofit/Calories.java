package aadoo.system.com.caloriesappretrofit.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Calories {

    @SerializedName("name")
    private String Name;

    @SerializedName("image_path")
    private String Image_path;

    @SerializedName("calories")
    private int Calories;

    public String getName() {
        return Name;
    }

    public String getImage_path() {
        return Image_path;
    }

    public int getCalories() {
        return Calories;
    }
}
