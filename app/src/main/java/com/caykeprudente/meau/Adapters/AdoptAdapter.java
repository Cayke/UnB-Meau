package com.caykeprudente.meau.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.caykeprudente.meau.Models.MainData;
import com.caykeprudente.meau.Models.Pet;
import com.caykeprudente.meau.MyApplication;
import com.caykeprudente.meau.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cayke on 03/11/16.
 */

public class AdoptAdapter extends RecyclerView.Adapter {
    public enum InitAnimalsFrom{
        adopt, apadrinhar, help, favorites
    }

    List<Pet> pets;

    public AdoptAdapter (InitAnimalsFrom screen)
    {
        if (screen == InitAnimalsFrom.adopt)
        {
            pets = MainData.getInstance().getPetsForAdopt();
        }
        else if (screen == InitAnimalsFrom.apadrinhar)
        {
            pets = MainData.getInstance().getPetsForApadrinhar();
        }
        else if (screen == InitAnimalsFrom.help)
        {
            pets = MainData.getInstance().getPetsForHelp();
        }
        else if (screen == InitAnimalsFrom.favorites)
        {
            pets = MainData.getInstance().getFavoritePets();
        }
    }

    public Pet getPetAtIndex(int index)
    {
        return pets.get(index);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adopt_fragment_cell, parent, false);
        return new AdoptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Pet pet = pets.get(position);

        AdoptViewHolder mHolder = (AdoptViewHolder) holder;
        mHolder.setData(pet);
    }

    public class AdoptViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageButton button;
        TextView name_tv, sex_tv, age_tv, size_tv, location_tv;

        public AdoptViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.adopt_fragment_cell_image_view);
            button = (ImageButton) itemView.findViewById(R.id.adopt_fragment_cell_like_btn);
            name_tv = (TextView) itemView.findViewById(R.id.adopt_fragment_cell_pet_name);
            sex_tv = (TextView) itemView.findViewById(R.id.adopt_fragment_cell_sex_text_view);
            age_tv = (TextView) itemView.findViewById(R.id.adopt_fragment_cell_age_text_view);
            size_tv = (TextView) itemView.findViewById(R.id.adopt_fragment_cell_size_text_view);
            location_tv = (TextView) itemView.findViewById(R.id.adopt_fragment_cell_location_text_view);
        }

        public void setData(final Pet pet)
        {
            Picasso.with(MyApplication.getAppContext()).load(pet.getImageResource()).resize(344,184).into(imageView);

            if (pet.getLiked())
                button.setImageResource(R.drawable.ic_favorite_black_48dp);
            else
                button.setImageResource(R.drawable.ic_favorite_border_black_48dp);

            name_tv.setText(pet.getName());
            sex_tv.setText(pet.getSex());
            age_tv.setText(pet.getAge());
            size_tv.setText(pet.getSize());
            location_tv.setText(pet.getLocation());

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (pet.getLiked())
                    {
                        pet.setLiked(false);
                        button.setImageResource(R.drawable.ic_favorite_border_black_48dp);
                    }
                    else
                    {
                        pet.setLiked(true);
                        button.setImageResource(R.drawable.ic_favorite_black_48dp);
                    }
                }
            });
        }
    }
}
