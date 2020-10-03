package com.example.mydroidcaffev1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoresFragment extends Fragment {
    //Step 2 : Declare private member variables
    private RecyclerView storesRecyclerView;
    private ArrayList<Store> storeData;
    private StoreAdapter storeAdapter;


    public StoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stores, container, false);
        /*2. Initialize recyclerView*/
        storesRecyclerView=rootView.findViewById(R.id.recycler_stores);
        //4. set layout for the recycler view
        storesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //5. Initialize the array list that will contain data
        storeData= new ArrayList<>();
        //6. Initilize the new recipe adapter
        storeAdapter= new StoreAdapter(storeData, getContext());
        //7. set the adapter
        storesRecyclerView.setAdapter(storeAdapter);
        //8. Get data
        initializeData();

//Implement swiping and moving card elements
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP,
                ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();
                Collections.swap(storeData,from,to);
                storeAdapter.notifyItemMoved(from, to);

                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                storeData.remove(viewHolder.getAdapterPosition());
                storeAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        })     ;
        helper.attachToRecyclerView(storesRecyclerView);
        return rootView;
    }

    private void initializeData() {
        //8.1 get the data created in the resource file: Strings.xml
        String[] restaurantTitles = getResources().getStringArray(R.array.restaurant_title);
        String[] restaurantHours = getResources().getStringArray(R.array.restaurant_hours);
        String[] restaurantDescription = getResources().getStringArray(R.array.restaurant_description);
        TypedArray restaurantImages = getResources().obtainTypedArray(R.array.restaurant_image);
        //8.2 Clear Existing data to avoid duplication
        storeData.clear();
        //8.3 Create an array list of dessert recipes with title description and images
        for (int i=0; i<restaurantTitles.length; i++){
            storeData.add(new Store(restaurantImages.getResourceId(i,  0),restaurantTitles[i], restaurantHours[i],restaurantDescription[i]));
        }
        //8.4 clean up data in the typed array
        restaurantImages.recycle();
        //8.5 notify adapter of the change in the data set``
        storeAdapter.notifyDataSetChanged();
    }


}
