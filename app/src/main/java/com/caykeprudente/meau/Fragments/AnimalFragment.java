package com.caykeprudente.meau.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.caykeprudente.meau.Models.Pet;
import com.caykeprudente.meau.MyApplication;
import com.caykeprudente.meau.R;
import com.squareup.picasso.Picasso;


public class AnimalFragment extends Fragment {
    Pet pet;
    ImageView imageView;
    TextView tvName, tvSex, tvSize, tvAge, tvLocation, tvCut, tvDewormed, tvVaccinated, tvDiseases, tvHumor, tvDonor_requirements, tvDescription;

    public AnimalFragment(Pet pet) {
        this.pet = pet;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_animal, container, false);

        tvName = (TextView) view.findViewById(R.id.animal_name);
        tvSex = (TextView) view.findViewById(R.id.animal_sex);
        tvSize = (TextView) view.findViewById(R.id.animal_porte);
        tvAge = (TextView) view.findViewById(R.id.animal_age);
        tvLocation = (TextView) view.findViewById(R.id.animal_loc);
        tvCut = (TextView) view.findViewById(R.id.animal_castrado);
        tvVaccinated = (TextView) view.findViewById(R.id.animal_vacinado);
        tvDewormed = (TextView) view.findViewById(R.id.animal_vermifungado);
        tvHumor = (TextView) view.findViewById(R.id.animal_temperamento);
        tvDiseases = (TextView) view.findViewById(R.id.animal_doencas);
        tvDonor_requirements = (TextView) view.findViewById(R.id.animal_exigencias);
        tvDescription = (TextView) view.findViewById(R.id.animal_desc);

        imageView = (ImageView) view.findViewById(R.id.img_animal);

        bindValues();

        return view;
    }

    private void bindValues()
    {
        Picasso.with(MyApplication.getAppContext()).load(pet.getImageResource()).resize(360,184).into(imageView);

        tvName.setText(pet.getName());
        tvSex.setText(pet.getSex());
        tvAge.setText(pet.getAge());
        tvSize.setText(pet.getSize());
        tvLocation.setText(pet.getLocation());
    }
}
