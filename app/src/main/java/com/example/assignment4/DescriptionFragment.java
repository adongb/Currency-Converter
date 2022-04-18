package com.example.assignment4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DescriptionFragment extends Fragment {

    private TextView descriptionView;
    public static String[] descriptionArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        descriptionArray = getResources().getStringArray(R.array.Descriptions);
        descriptionView = getActivity().findViewById(R.id.descriptionView);
    }

    public void showDescriptionAtIndex(int newIndex) {
        if (newIndex >= 0 && newIndex < descriptionArray.length)
            descriptionView.setText(descriptionArray[newIndex]);
    }
}
