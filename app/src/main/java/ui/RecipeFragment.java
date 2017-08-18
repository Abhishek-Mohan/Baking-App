package ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapters.RecipeGridAdapter;
import data.RecipeBuilder;
import data.RecipeService;
import fastrackm.nanodegree.udacity.abhis.yumrecipes.R;
import models.Recipe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by abhis on 8/17/2017.
 */

public class RecipeFragment extends Fragment
{
    RecyclerView mRecyclerView;
    GridLayoutManager mLayoutManager;

    public RecipeFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.recipe_items, container, false);

        mRecyclerView = rootView.findViewById(R.id.recyler_recipe);

        final RecipeGridAdapter recipeGridAdapter = new RecipeGridAdapter();

        mRecyclerView.setAdapter(recipeGridAdapter);

        mLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecipeService recipeGrabber = RecipeBuilder.getBakingJson();
        Call<ArrayList<Recipe>> mRecipe = recipeGrabber.getRecipe();

        mRecipe.enqueue(new Callback<ArrayList<Recipe>>() {
            @Override
            public void onResponse(Call<ArrayList<Recipe>> call, Response<ArrayList<Recipe>> response)
            {
                ArrayList<Recipe> recipeArrayList = response.body();

                Bundle recipeListBundle = new Bundle();
                recipeListBundle.putParcelableArrayList("recipeList", recipeArrayList);

                recipeGridAdapter.setRecipeListData(recipeArrayList, getContext());


            }

            @Override
            public void onFailure(Call<ArrayList<Recipe>> call, Throwable throwable) {
                Log.d("failure", throwable.getMessage());
            }
        });

        return rootView;
    }
}
