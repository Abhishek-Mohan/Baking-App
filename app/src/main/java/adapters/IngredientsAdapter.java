package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import fastrackm.nanodegree.udacity.abhis.yumrecipes.R;
import models.Ingredients;

/**
 * Created by abhis on 8/19/2017.
 */

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder>
{
    ArrayList<Ingredients> currentIngredients;

    public IngredientsAdapter()
    {

    }

    public IngredientsAdapter(ArrayList<Ingredients> ingredients)
    {
        currentIngredients = ingredients;
    }

    @Override
    public IngredientsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context currentContext = parent.getContext();
        int layoutID = R.layout.ingredients_layout;

        LayoutInflater inflater = LayoutInflater.from(currentContext);

        View view = inflater.inflate(layoutID, parent, false);

        return new IngredientsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IngredientsAdapter.ViewHolder holder, int position)
    {
        //holder.mQuantity

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView mQuantity;
        TextView mMeasure;
        TextView mIngredients;

        public ViewHolder(View itemView)
        {
            super(itemView);

            mQuantity = itemView.findViewById(R.id.ing_quantity);
            mMeasure = itemView.findViewById(R.id.ing_measure);
            mIngredients = itemView.findViewById(R.id.ing_ingredient);



        }
    }
}
