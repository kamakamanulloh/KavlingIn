package com.putri.skripsi.kavlingin.MenuFragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.putri.skripsi.kavlingin.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabTransaksiFragment extends Fragment {


    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;
    public static final int int_items=3;


    public TabTransaksiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_transaksi, container, false);
        unbinder = ButterKnife.bind(this, view);
        viewpager.setAdapter(new GrafikTabAdapter(getChildFragmentManager()));
        tabs.post(new Runnable() {
            @Override
            public void run() {
                tabs.setupWithViewPager(viewpager);
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    class GrafikTabAdapter extends FragmentPagerAdapter {
        public GrafikTabAdapter(FragmentManager fm) {
            super(fm);
        }

        //Return fragment with respect to position
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TabTroli();
                case 1:
                    return new TabPenjualan();
                case 2:
                    return new TabPembelian();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        //change title
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Keranjang Anda";
                case 1:
                    return "Penjualan";
                case 2:
                    return "Pembelian";
            }
            return null;
        }
    }
}
