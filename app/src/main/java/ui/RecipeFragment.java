package ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fastrackm.nanodegree.udacity.abhis.yumrecipes.R;

/**
 * Created by abhis on 8/17/2017.
 */

public class RecipeFragment extends Fragment
{
    public RecipeFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.recipe_items, container, false);

        return root;
    }
}
