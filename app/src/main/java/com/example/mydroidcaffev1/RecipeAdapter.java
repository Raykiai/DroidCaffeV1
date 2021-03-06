package com.example.mydroidcaffev1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/* 1. Create a recipe adapter that extends Recyclerview.Adapter and use the RecyclerView.viewHolder class */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    //Step 3.0 Declare the private ember variables Recipe data and the context
    private ArrayList<Recipe> recipeData;
    private Context myContext;
    /*Step 3.1 Create constructor to pass in the recipe data and the context
     */
    RecipeAdapter(ArrayList<Recipe> mRecipeData, Context context){
        //initialize the objects
        this.myContext= context;
        this.recipeData= mRecipeData;

    }

    /*
    Implement method onCreateViewHolder for creating viewHolder objects
    @param parent the view group of which the object will be added after it is bound to the adapter position
    @param viewType of the new view
    @return the newly created viewHolder
    */

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Step 4.1 Create a new view holder

        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item,parent, false));
    }
    /*step 1.1 required for binding the view to the data
       @holder viewHolder which the data should put
       @position the adapter position
       * */
    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        //Step 5. Get the current view object using it's position and populate it with data
        Recipe currentRecipe= recipeData.get(position);
        //Step 5.1 Populate the current view with data
        holder.bindTo(currentRecipe);

    }
   /*Step 1.1  Required for getting the size of the data set
   @return the size of the dataset
   * */

    @Override
    public int getItemCount() {
        //Step 4.0 return the size
        return recipeData.size();
    }



    /*Step 2 Create the view holder class that represents eachand every row in the recycler View
    * */
    public class ViewHolder extends RecyclerView.ViewHolder {
/* Step 2.1
Create a constructor for the ViewHolder used onCreateViewHolder
@param itemView refers to rootView of the recipe_list_item layout
* */
        //Step 2.2 declare the private member variables
        private ImageView myRecipeImage;
        private TextView myRecipeTitle;
        private TextView myRecipePrep;
        private TextView myRecipeDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myRecipeImage = itemView.findViewById(R.id.recipe_image);
            myRecipeTitle = itemView.findViewById(R.id.recipe_title);
            myRecipePrep = itemView.findViewById(R.id.recipe_prep);
            myRecipeDescription = itemView.findViewById(R.id.recipe_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dessertPosition = getAdapterPosition();
                    Recipe currentDessert = recipeData.get(dessertPosition);
                    if(dessertPosition>=0){
                        Intent donutIntent = new Intent(myContext, DonutActivity.class);
                        donutIntent.putExtra("dTitle", currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dPrep", currentDessert.getRecipePrep());
                        donutIntent.putExtra("dImage", currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription", currentDessert.getRecipeDescription());

                        myContext.startActivity(donutIntent);
                    }else{
                        Toast.makeText(myContext, "create an activity for the dessert", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

        //Step 6 Create a method to bind the current view with data (Image, title and description)

        public void bindTo(Recipe currentRecipe) {
            /*6.1 Populate the view with the data
            *For loading the image, use the Glide lbrary so as to prevent app from rrasshing
            * as a result of loading many images of different resolutions
            * Implement the glide library first in your Gradle module(app) level
            */
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipePrep.setText(currentRecipe.getRecipePrep());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());
        }
    }
}
