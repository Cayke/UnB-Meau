package com.caykeprudente.meau.Models;

import com.caykeprudente.meau.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cayke on 24/11/16.
 */

public class MainData {

    private List<Pet> pets;

    private static MainData instance = null;

    private MainData() {
        // Exists only to defeat instantiation.
    }
    public static MainData getInstance() {
        if(instance == null) {
            instance = new MainData();
        }
        return instance;
    }

    private void generatePets()
    {
        pets = new ArrayList<>();
        pets.add(new Pet("Pequi", "Macho", "Adulto", "Médio", "Sabambaia Sul - DF", R.drawable.pequi, false, "Dog"));
        pets.add(new Pet("Bidu", "Macho", "Adulto", "Médio", "Asa Norte - DF", R.drawable.bidu, false, "Dog"));
        pets.add(new Pet("Alec", "Macho", "Idoso", "Pequeno", "Noroeste - DF", R.drawable.alec, true, "Cat"));

        pets.add(new Pet("Margot", "Fêmea", "Idosa", "Grande", "Lago Sul - DF", R.drawable.margot, false, "Dog"));
        pets.add(new Pet("Marie", "Fêmea", "Adulta", "Médio", "Sudoeste - DF", R.drawable.marie, false, "Cat"));
        pets.add(new Pet("Sanco", "Macho", "Adulto", "Grande", "Guará - DF", R.drawable.sancho, true, "Dog"));

        pets.add(new Pet("Toto", "Macho", "Filhote", "Pequeno", "Taguatinga - DF", R.drawable.toto, false, "Dog"));
        pets.add(new Pet("Rex", "Macho", "Adulto", "Pequeno", "Nucleo Bandeirante - DF", R.drawable.rex, false, "Dog"));
        pets.add(new Pet("Murilo", "Macho", "Idoso", "Medio", "Sudoeste - DF", R.drawable.jorge, true, "Cat"));
        pets.add(new Pet("Penelope", "Femea", "Adulto", "Pequeno", "Jardim Botanico - DF", R.drawable.penelope, false, "Dog"));
    }

    public List<Pet> getPetsForAdopt()
    {
        if (pets == null)
            generatePets();

        return pets;
    }

    public List<Pet> getPetsForHelp()
    {
        if (pets == null)
            generatePets();

        List<Pet> array = new ArrayList();
        array.add(pets.get(3));
        array.add(pets.get(4));
        array.add(pets.get(5));
        array.add(pets.get(9));
        array.add(pets.get(0));
        array.add(pets.get(7));
        array.add(pets.get(2));
        array.add(pets.get(6));
        array.add(pets.get(1));
        array.add(pets.get(8));

        return array;
    }

    public List<Pet> getPetsForApadrinhar()
    {
        if (pets == null)
            generatePets();

        List<Pet> array = new ArrayList();
        array.add(pets.get(6));
        array.add(pets.get(7));
        array.add(pets.get(8));
        array.add(pets.get(9));
        array.add(pets.get(0));
        array.add(pets.get(4));
        array.add(pets.get(2));
        array.add(pets.get(3));
        array.add(pets.get(1));
        array.add(pets.get(5));

        return array;
    }

    public List<Pet> getFavoritePets()
    {
        if (pets == null)
            generatePets();

        List<Pet> array = new ArrayList();
        for (Pet pet : pets)
        {
            if (pet.getLiked())
                array.add(pet);
        }

        return array;
    }
}
