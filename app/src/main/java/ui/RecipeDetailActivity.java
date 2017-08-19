package ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;

import fastrackm.nanodegree.udacity.abhis.yumrecipes.R;
import models.Recipe;

/**
 * Created by abhis on 8/17/2017.
 */

public class RecipeDetailActivity extends AppCompatActivity
{
    private String TAG = RecipeDetailActivity.class.getName();
    //private boolean isTwoPane = false;

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
