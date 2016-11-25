package com.caykeprudente.meau.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.caykeprudente.meau.AppActivity;
import com.caykeprudente.meau.R;

import static com.caykeprudente.meau.R.style.adoptTheme;

/**
 * Created by Leandro on 24/11/2016.
 */

public class LegislacaoFragment extends Fragment {

    public static FragmentManager mainFragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_legislacao, container, false);

        final Context mContext = view.getContext();

        ((AppActivity) getActivity()).getSupportActionBar().setTitle("Legislação");


        return view;
    }
}
