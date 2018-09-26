package com.example.ewanburns_wilton.beautifuldog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BulldogListFragment extends Fragment {

    private RecyclerView bulldogList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter bulldogAdapter;

    public BulldogListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bulldog_list, container, false);

        ArrayList<Bulldog> bulldogs = new ArrayList<Bulldog>();
        bulldogList = (RecyclerView)view.findViewById(R.id.bulldog_list);

        Bulldog bulldog1 = new Bulldog();
        bulldog1.setAge("10");
        bulldog1.setName("Ruby");


        Bulldog bulldog2 = new Bulldog();
        bulldog2.setAge("1");
        bulldog2.setName("Marley");

        bulldogs.add(bulldog1);
        bulldogs.add(bulldog2);

        layoutManager = new LinearLayoutManager(getContext());
        bulldogList.setLayoutManager(layoutManager);

        bulldogAdapter = new BulldogAdapter(getContext(), bulldogs);
        bulldogList.setAdapter(bulldogAdapter);

        return view;
    }

}