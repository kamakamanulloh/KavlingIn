package com.putri.skripsi.kavlingin.MenuFragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.putri.skripsi.kavlingin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabPembelian extends Fragment {


    public TabPembelian() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_pembelian, container, false);
    }

}
