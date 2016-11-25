package com.caykeprudente.meau.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caykeprudente.meau.Adapters.AdoptAdapter;
import com.caykeprudente.meau.AppActivity;
import com.caykeprudente.meau.R;

/**
 * Created by cayke on 24/11/16.
 */

public class PatronizeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adopt_fragment, container, false);

        final Context mContext = view.getContext();
        ((AppActivity) getActivity()).getSupportActionBar().setTitle("Apadrinhar");

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.adopt_fragment_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        AdoptAdapter adapter = new AdoptAdapter(AdoptAdapter.InitAnimalsFrom.apadrinhar);
        recyclerView.setAdapter(adapter);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                if (mContext instanceof AppActivity) {
                    AppActivity mainActivity = (AppActivity) mContext;
                    mainActivity.switchToAnimalFragment();
                }
            }
        });

        return view;
    }
}