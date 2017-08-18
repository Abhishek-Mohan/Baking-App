package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abhis on 8/16/2017.
 */

public final class RecipeBuilder
{
    private static RecipeService recipeService;

    public static RecipeService getBakingJson()
    {
        Gson gson = new GsonBuilder().create();
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();


        recipeService = new Retrofit.Builder()
                .baseUrl("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callFactory(httpClientBuilder.build())
                .build().create(RecipeService.class);


        return recipeService;
    }
}
