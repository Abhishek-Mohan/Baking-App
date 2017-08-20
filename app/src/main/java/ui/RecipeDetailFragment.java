package ui;

import android.support.v4.app.Fragment;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import adapters.RecipeStepsAdapter;
import fastrackm.nanodegree.udacity.abhis.yumrecipes.R;
import models.Recipe;
import models.Steps;

/**
 * Created by abhis on 8/17/2017.
 */

public class RecipeDetailFragment extends Fragment
{
    private String TAG = RecipeDetailFragment.class.getName();
    ArrayList<Steps> recipeSteps;
    Recipe currentRecipe;
    String recipeName;

    RecyclerView mRecyclerView;
    LinearLayoutManager mStepLayoutManager;



    public RecipeDetailFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //recipeSteps = new ArrayList<>();

        currentRecipe = getArguments().getParcelable("recipe");
        recipeSteps = currentRecipe.getSteps();

        //Log.d(TAG, recipeSteps.get(0).getShortDescription());

        View rootView = inflater.inflate(R.layout.recipe_detail_fragment_list, container, false);


        mRecyclerView = rootView.findViewById(R.id.recipe_steps_recycler);
        RecipeStepsAdapter mRecipeStepAdapter = new RecipeStepsAdapter((RecipeDetailActivity)getActivity(), recipeSteps, getContext());
        mRecyclerView.setAdapter(mRecipeStepAdapter);

        mStepLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mStepLayoutManager);

        return rootView;

    }




}
