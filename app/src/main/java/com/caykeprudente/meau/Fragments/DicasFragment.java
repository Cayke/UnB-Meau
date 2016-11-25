package com.caykeprudente.meau.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.Switch;

import com.caykeprudente.meau.Adapters.DicasAdapter;
import com.caykeprudente.meau.AppActivity;
import com.caykeprudente.meau.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Leandro on 25/11/2016.
 */

public class DicasFragment extends Fragment{
    DicasAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public static FragmentManager mainFragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dicas_fragment, container, false);

        final Context mContext = view.getContext();
        ((AppActivity) getActivity()).getSupportActionBar().setTitle("Dicas");

        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);
        prepareListData();

        listAdapter = new DicasAdapter(this.getActivity(), listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);

        return view;

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Comportamento");

        List<String> comportamento = new ArrayList<String>();
        comportamento.add("Cão vs gato: qual deve ser o seu bichinho?");
        comportamento.add("Como lidar com pets muito agitados");
        comportamento.add("Porque alguns animais não gostam de crianças?");

        listDataChild.put(listDataHeader.get(0), comportamento);

        listDataHeader.add("Alimentação");

        List<String> alimentacao = new ArrayList<String>();
        alimentacao.add("A importância de alimentar o pet com ração");
        alimentacao.add("Quais frutas você pode e não pode dar ao seu pet");
        alimentacao.add("Como escolho a melhor ração para o meu pet?");
        alimentacao.add("Socorro! O meu pet não quer mais comer ração!");

        listDataChild.put(listDataHeader.get(1), alimentacao);

        listDataHeader.add("Saúde");

        List<String> saude = new ArrayList<String>();
        saude.add("Como cortar as unhas do seu cachorro");
        saude.add("Mantendo a pele e pelagem do seu pet saudável");
        saude.add("Como identificar dor em cães?");
        saude.add("Nariz seco é sinal de doença?");
        saude.add("Colocando micro-chip em seu cachorro");
        saude.add("Vermes em cães e gatos");
        saude.add("Como limpar as orelhas do seu cachorro");
        saude.add("Livrando-se das pulgas e carrapatos!");
        saude.add("Câncer em cachorros");

        listDataChild.put(listDataHeader.get(2), saude);

    }
}
