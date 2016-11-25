package com.caykeprudente.meau.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.caykeprudente.meau.AppActivity;
import com.caykeprudente.meau.MyApplication;
import com.caykeprudente.meau.R;
import com.squareup.picasso.Picasso;

/**
 * Created by cayke on 24/11/16.
 */

public class MyPetsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppActivity) getActivity()).getSupportActionBar().setTitle("Meus Pets");
        View view =  inflater.inflate(R.layout.my_pets_fragment, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.my_pets_fragment_image_view);
        Picasso.with(MyApplication.getAppContext()).load(R.drawable.my_pets).resize(748,1059).into(imageView);

        return view;
    }
}
