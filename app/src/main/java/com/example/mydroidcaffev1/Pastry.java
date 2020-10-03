package com.example.mydroidcaffev1;

public class Pastry {
    //declare private member variable
    private final int pastryImage;
    private String pastryTitle;
    private String pastryPrep;
    private String pastryDescription;

    /* create constructor for recipe data model and pass data for recipeImage, title and description
     */
    Pastry(int pastryImage, String pastryTitle, String pastryPrep, String pastryDescription){
        this.pastryImage = pastryImage;
        this.pastryTitle = pastryTitle;
        this.pastryPrep = pastryPrep;
        this.pastryDescription = pastryDescription;

    }
    //create getters amd return specific object
    public int getPastryImage(){
        return pastryImage;
    }
    public String getPastryTitle(){
        return pastryTitle;
    }
    public String getPastryPrep(){
        return pastryPrep;
    }
    public String getPastryDescription(){
        return pastryDescription;
    }


}
