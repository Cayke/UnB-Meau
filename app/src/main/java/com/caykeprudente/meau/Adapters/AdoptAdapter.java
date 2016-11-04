package com.caykeprudente.meau.Adapters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.caykeprudente.meau.Models.ImageWrapper;
import com.caykeprudente.meau.Models.Pet;
import com.caykeprudente.meau.MyApplication;
import com.caykeprudente.meau.R;

import java.util.List;

/**
 * Created by cayke on 03/11/16.
 */

public class AdoptAdapter extends RecyclerView.Adapter {
    List<Pet> pets;

    public AdoptAdapter ()
    {
        pets = Pet.generatePets();
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
        mHolder.setData(pet.getImageResource(), pet.getLiked(), pet.getName(), pet.getSex(), pet.getAge(), pet.getSize(), pet.getLocation());
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

        public void setData(int image, Boolean liked, String name, String sex, String age, String size, String location)
        {
            imageView.setImageBitmap(
                    ImageWrapper.decodeSampledBitmapFromResource(MyApplication.getAppContext().getResources(), image, 344, 184));
            if (liked)
                button.setImageResource(R.drawable.ic_favorite_black_48dp);
            else
                button.setImageResource(R.drawable.ic_favorite_border_black_48dp);

            name_tv.setText(name);
            sex_tv.setText(sex);
            age_tv.setText(age);
            size_tv.setText(size);
            location_tv.setText(location);
        }
    }
}
