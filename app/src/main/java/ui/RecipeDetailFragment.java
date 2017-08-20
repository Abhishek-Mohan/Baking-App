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
    String recipeName;

    RecyclerView mRecyclerView;


    public RecipeDetailFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        recipeSteps = new ArrayList<>();

        recipeSteps = getArguments().getParcelableArrayList("ingSteps");

        Log.d(TAG, recipeSteps.get(0).getShortDescription());

        View rootView = inflater.inflate(R.layout.recipe_detail_fragment_list, container, false);

        mRecyclerView = rootView.findViewById(R.id.recipe_steps_recycler);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecipeStepsAdapter mRecipeStepAdapter = new RecipeStepsAdapter((RecipeDetailActivity)getActivity(), recipeSteps, getContext());
        mRecyclerView.setAdapter(mRecipeStepAdapter);
        //mRecipeStepAdapter.setMasterRecipeData(recipeSteps, getContext());


        return rootView;

    }




}
