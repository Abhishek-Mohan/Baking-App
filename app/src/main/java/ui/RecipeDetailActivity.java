package ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.IngredientsAdapter;
import adapters.RecipeStepsAdapter;
import fastrackm.nanodegree.udacity.abhis.yumrecipes.R;
import models.Ingredients;
import models.Recipe;
import models.Steps;

/**
 * Created by abhis on 8/17/2017.
 */

public class RecipeDetailActivity extends AppCompatActivity implements RecipeStepsAdapter.StepItemClickListener, RecipeStepFragment.ListItemClickListener
{
    private String TAG = RecipeDetailActivity.class.getName();

    static String ALL_RECIPES="All_Recipes";
    static String SELECTED_RECIPES="Selected_Recipes";
    static String SELECTED_STEPS="Selected_Steps";
    static String SELECTED_INDEX="Selected_Index";
    static String STACK_RECIPE_DETAIL="STACK_RECIPE_DETAIL";
    static String STACK_RECIPE_STEP_DETAIL="STACK_RECIPE_STEP_DETAIL";



    //private boolean isTwoPane = false;

    RecyclerView mIngRecyclerView;
    RecyclerView mRecyclerView;
    LinearLayoutManager mIngLayoutManager;
    LinearLayoutManager mStepLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Bundle currentRecipeBundle = getIntent().getExtras();

        Recipe currentRecipe = currentRecipeBundle.getParcelable("RecipeItem");
        getSupportActionBar().setTitle(currentRecipe.getName());

        //Toast.makeText(this, currentRecipe.getName(), Toast.LENGTH_SHORT).show();
        //Log.d(TAG, String.valueOf(currentRecipe.getId()));

        ArrayList<Ingredients> list = currentRecipe.getIngredients();

        mIngRecyclerView = findViewById(R.id.rvIngredients);

        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(list);
        mIngRecyclerView.setAdapter(ingredientsAdapter);

        mIngLayoutManager = new LinearLayoutManager(this);
        mIngRecyclerView.setLayoutManager(mIngLayoutManager);

      //ArrayList<Steps> listSteps = currentRecipe.getSteps();
        /*Toast.makeText(this, listSteps.get(0).getShortDescription(), Toast.LENGTH_SHORT).show();

        mRecyclerView = findViewById(R.id.recipe_steps_recycler);
        RecipeStepsAdapter mRecipeStepAdapter = new RecipeStepsAdapter((RecipeDetailActivity)getActivty(), listSteps, this);
        mRecyclerView.setAdapter(mRecipeStepAdapter);

        mStepLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mStepLayoutManager);*/



        Bundle selectedRecipeBundle = new Bundle();
        selectedRecipeBundle.putParcelable("recipe", currentRecipe);

        RecipeDetailFragment fragment = new RecipeDetailFragment();
        fragment.setArguments(selectedRecipeBundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment).addToBackStack(STACK_RECIPE_DETAIL)
                .commit();


    }

    @Override
    public void onStepClick(ArrayList<Steps> steps, int position)
    {
        //Log.d(TAG, "does it get to this method?");
        final RecipeStepFragment fragment = new RecipeStepFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();

        //getSupportActionBar().setTitle(recipeName);

        Bundle stepBundle = new Bundle();
        stepBundle.putParcelableArrayList("SELECTED_STEPS",steps);
        stepBundle.putInt("SELECTED_INDEX",position);
        stepBundle.putString("Title","Nutella");
        fragment.setArguments(stepBundle);

        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment).addToBackStack(STACK_RECIPE_STEP_DETAIL)
                .commit();

       /* if (findViewById(R.id.recipe_linear_layout).getTag()!=null && findViewById(R.id.recipe_linear_layout).getTag().equals("tablet-land")) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container2, fragment).addToBackStack(STACK_RECIPE_STEP_DETAIL)
                    .commit();

        }
        else {*/
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment).addToBackStack(STACK_RECIPE_STEP_DETAIL)
                    .commit();
        //}

    }

    @Override
    public void onListItemClick(List<Steps> allSteps, int Index, String recipeName) {
        final RecipeStepFragment fragment = new RecipeStepFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();

        getSupportActionBar().setTitle(recipeName);

        Bundle stepBundle = new Bundle();
        stepBundle.putParcelableArrayList("SELECTED_STEPS",(ArrayList<Steps>) allSteps);
        stepBundle.putInt("SELECTED_INDEX",Index);
        stepBundle.putString("Title",recipeName);
        fragment.setArguments(stepBundle);

   /*     if (findViewById(R.id.recipe_linear_layout).getTag()!=null && findViewById(R.id.recipe_linear_layout).getTag().equals("tablet-land")) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container2, fragment).addToBackStack(STACK_RECIPE_STEP_DETAIL)
                    .commit();

        }
        else {*/
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment).addToBackStack(STACK_RECIPE_STEP_DETAIL)
                    .commit();
        //}
    }


    //determinePaneLayout();


    /*private void determinePaneLayout() {
        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.flDetailContainer);
        if (fragmentItemDetail != null) {
            isTwoPane = true;
            RecipeDetailFragment fragmentItemsList =
                    (RecipeDetailFragment) getSupportFragmentManager().findFragmentById(R.id.recipe_fragment_body);
            //fragmentItemsList.setActivateOnItemClick(true);
        }
    }*/

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.items, menu);
        return true;
    }*/
}
