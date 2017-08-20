package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import fastrackm.nanodegree.udacity.abhis.yumrecipes.R;
import models.Steps;

/**
 * Created by abhis on 8/19/2017.
 */

public class RecipeStepsAdapter extends RecyclerView.Adapter<RecipeStepsAdapter.ViewHolder>
{
    private ArrayList<Steps> listSteps;
    private StepItemClickListener onClickHandler;
    private Context mContext;

    public interface StepItemClickListener
    {
        void onStepClick();
    }

    public RecipeStepsAdapter(StepItemClickListener listener, ArrayList<Steps> steps, Context context)
    {
        onClickHandler = listener;
        listSteps = steps;
        mContext = context;
    }

    public void setMasterRecipeData(ArrayList<Steps> steps, Context context)
    {
        listSteps = steps;
        notifyDataSetChanged();
    }


    @Override
    public RecipeStepsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.recipe_detail_step_items;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeStepsAdapter.ViewHolder holder, int position) {
        holder.shortDescription.setText(listSteps.get(position).getId() + ". " + listSteps.get(position).getShortDescription());
        Log.d("RecipeSTepsAdapter", listSteps.get(position).getShortDescription());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView shortDescription;

        public ViewHolder(View itemView)
        {
            super(itemView);
            shortDescription = itemView.findViewById(R.id.shortDescription);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            int clickedPosition = getAdapterPosition();


        }
    }
}
