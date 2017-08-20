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

import adapters.IngredientsAdapter;
import adapters.RecipeStepsAdapter;
import fastrackm.nanodegree.udacity.abhis.yumrecipes.R;
import models.Ingredients;
import models.Recipe;
import models.Steps;

/**
 * Created by abhis on 8/17/2017.
 */

public class RecipeDetailActivity extends AppCompatActivity implements RecipeStepsAdapter.StepItemClickListener
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
    LinearLayoutManager mIngLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Nutella");

        Bundle currentRecipeBundle = getIntent().getExtras();

        Recipe currentRecipe = currentRecipeBundle.getParcelable("RecipeItem");

        Toast.makeText(this, currentRecipe.getName(), Toast.LENGTH_SHORT).show();
        //Log.d(TAG, String.valueOf(currentRecipe.getId()));

     /*   ArrayList<Ingredients> list = currentRecipe.getIngredients();

        mIngRecyclerView = findViewById(R.id.rvIngredients);

        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(list);
        mIngRecyclerView.setAdapter(ingredientsAdapter);

        mIngLayoutManager = new LinearLayoutManager(this);
        mIngRecyclerView.setLayoutManager(mIngLayoutManager);*/

        ArrayList<Steps> listSteps = currentRecipe.getSteps();
        Bundle selectedRecipeBundle = new Bundle();
        selectedRecipeBundle.putParcelableArrayList("ingSteps", listSteps);

        RecipeDetailFragment fragment = new RecipeDetailFragment();
        fragment.setArguments(selectedRecipeBundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();



    }

    @Override
    public void onStepClick() {

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
