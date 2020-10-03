package com.example.mydroidcaffev1;

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
public class PastriesRecipeFragment extends Fragment {
    //Step 2 : Declare private member variables
    private RecyclerView pastryRecyclerView;
    private ArrayList<Pastry> pastryData;
    private PastryAdapter pastryAdapter;


    public PastriesRecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pastries_recipe, container, false);
        /*2. Initialize recyclerView*/
        pastryRecyclerView=rootView.findViewById(R.id.recycler_pastries);
        //4. set layout for the recycler view
        pastryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //5. Initialize the array list that will contain data
        pastryData= new ArrayList<>();
        //6. Initilize the new recipe adapter
        pastryAdapter= new PastryAdapter(pastryData, getContext());
        //7. set the adapter
        pastryRecyclerView.setAdapter(pastryAdapter);
        //8. Get data
        initializeData();


//Implement swiping and moving card elements
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP,
                ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();
                Collections.swap(pastryData,from,to);
                pastryAdapter.notifyItemMoved(from, to);

                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                pastryData.remove(viewHolder.getAdapterPosition());
                pastryAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        })     ;
        helper.attachToRecyclerView(pastryRecyclerView);
        return rootView;
    }

    private void initializeData() {
        //8.1 get the data created in the resource file: Strings.xml
        String[] pastryTitles = getResources().getStringArray(R.array.bakes_title);
        String[] pastryPrep = getResources().getStringArray(R.array.bakes_prep);
        String[] pastryDescription = getResources().getStringArray(R.array.bakes_description);
        TypedArray pastryImages = getResources().obtainTypedArray(R.array.bakes_images);
        //8.2 Clear Existing data to avoid duplication
        pastryData.clear();
        //8.3 Create an array list of dessert recipes with title description and images
        for (int i=0; i<pastryTitles.length; i++){
            pastryData.add(new Pastry(pastryImages.getResourceId(i,  0),pastryTitles[i], pastryPrep[i],pastryDescription[i]));
        }
        //8.4 clean up data in the typed array
        pastryImages.recycle();
        //8.5 notify adapter of the change in the data set``
        pastryAdapter.notifyDataSetChanged();
    }
}
