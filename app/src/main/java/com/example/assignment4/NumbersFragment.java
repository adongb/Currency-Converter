package com.example.assignment4;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

public class NumbersFragment extends ListFragment {

    public static String[] numberArray;

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        numberArray = getResources().getStringArray(R.array.Numbers);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                numberArray);
        setListAdapter(myAdapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        DescriptionFragment descriptionsFragment = (DescriptionFragment)getFragmentManager()
                .findFragmentById(R.id.descriptions);
        descriptionsFragment.showDescriptionAtIndex(position);
    }

}
