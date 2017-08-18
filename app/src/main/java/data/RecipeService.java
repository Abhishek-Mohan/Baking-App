package data;

import java.util.ArrayList;

import models.Recipe;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by abhis on 8/16/2017.
 */

public interface RecipeService {
    @GET("baking.json")
    Call<ArrayList<Recipe>> getRecipe();
}