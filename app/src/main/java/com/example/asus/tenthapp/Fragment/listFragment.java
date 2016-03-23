package com.example.asus.tenthapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.tenthapp.R;
import com.example.asus.tenthapp.Utils.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class listFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        List<String>list = new ArrayList<>();

        recordList (list);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(itemAnimator);

        return  view;
    }

    private void recordList (List list) {
        for (int i = 1; i<81; i++){
            list.add("Item#" + i);
        }
    }


}
