package com.example.mydroidcaffev1;

public class Store {
    //declare private member variable
    private final int storeImage;
    private String storeTitle;
    private String storeOpen;
    private String storeDescription;

    /* create constructor for recipe data model and pass data for recipeImage, title and description
     */
    Store(int storeImage, String storeTitle, String storeOpen, String storeDescription){
        this.storeImage = storeImage;
        this.storeTitle = storeTitle;
        this.storeOpen = storeOpen;
        this.storeDescription = storeDescription;

    }
    //create getters amd return specific object
    public int getStoreImage(){
        return storeImage;
    }
    public String getStoreTitle(){
        return storeTitle;
    }
    public String getStoreOpen(){
        return storeOpen;
    }
    public String getStoreDescription(){
        return storeDescription;
    }


}
