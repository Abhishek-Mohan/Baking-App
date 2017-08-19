package ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.RecipeGridAdapter;
import fastrackm.nanodegree.udacity.abhis.yumrecipes.R;
import models.Recipe;

/**
 * Created by abhis on 8/16/2017.
 */

public class MainActivity extends AppCompatActivity implements RecipeGridAdapter.RecipeGridAdapterClickHandler
{
    private String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Baking Time");
    }
    
    @Override
    public void onClick(Recipe currentRecipe) 
    {
        Log.d(TAG, "does it get here?");
        Toast.makeText(this, "does this work", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, RecipeDetailActivity.class);
        Bundle recipeBundle = new Bundle();
        recipeBundle.putParcelable("RecipeItem", currentRecipe);
        intent.putExtras(recipeBundle);
        startActivity(intent);
    }
}

