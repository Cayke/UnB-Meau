package com.caykeprudente.meau.Fragments;

import android.support.annotation.Nullable;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.caykeprudente.meau.AppActivity;
import com.caykeprudente.meau.R;

public class TermoAdocaoFragment extends Fragment {

    public static FragmentManager mainFragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_termo_adocao, container, false);

        final Context mContext = view.getContext();
        ((AppActivity) getActivity()).getSupportActionBar().setTitle("Termo de adoção");

        final Button buttonAdocao = (Button) view.findViewById(R.id.but_term_ado);
        buttonAdocao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFragmentManager.beginTransaction().replace(R.id.container, new SuccessTermoFragment()).commit();
            }
        });

        final Button buttonApadrinha = (Button) view.findViewById(R.id.but_term_apa);
        buttonApadrinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFragmentManager.beginTransaction().replace(R.id.container, new SuccessTermoFragment()).commit();
            }
        });

        return view;
    }
}
