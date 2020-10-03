package com.example.mydroidcaffev1;

public class Recipe {
    //declare private member variable
    private final int recipeImage;
    private String recipeTitle;
    private String recipePrep;
    private String recipeDescription;

    /* create constructor for recipe data model and pass data for recipeImage, title and description
    */
    Recipe(int recipeImage, String recipeTitle, String recipePrep, String recipeDescription){
        this.recipeImage = recipeImage;
        this.recipeTitle = recipeTitle;
        this.recipePrep = recipePrep;
        this.recipeDescription = recipeDescription;

    }
    //create getters amd return specific object
    public int getRecipeImage(){
        return recipeImage;
    }
    public String getRecipeTitle(){
        return recipeTitle;
    }
    public String getRecipePrep(){
        return recipePrep;
    }
    public String getRecipeDescription(){
        return recipeDescription;
    }


}
