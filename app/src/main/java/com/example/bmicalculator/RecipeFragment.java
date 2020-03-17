package com.example.bmicalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RecipeFragment extends Fragment {
    private String[] items;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        listView =  view.findViewById(R.id.ingridientListView);
        items = getResources().getStringArray(R.array.ingridientsList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext() ,android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        return view;
    }
}
