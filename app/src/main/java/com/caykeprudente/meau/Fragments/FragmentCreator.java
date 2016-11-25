package com.caykeprudente.meau.Fragments;

import android.support.v4.app.Fragment;

import com.caykeprudente.meau.MyApplication;
import com.caykeprudente.meau.R;

/**
 * Created by cayke on 03/11/16.
 */

public class FragmentCreator {
    // RECEBE O NOME DA TELA E RETORNA O FRAGMENT EQUIVALENTE
    public static Fragment newInstance(String screenName)
    {
        if (screenName.equals(MyApplication.getAppContext().getString(R.string.adopt_pet)))
            return new AdoptFragment();

        else if (screenName.equals(MyApplication.getAppContext().getString(R.string.register_pet)))
            return new RegisterAnimalFragment();

        else if (screenName.equals(MyApplication.getAppContext().getString(R.string.help_pet)))
            return new HelpFragment();

        else if (screenName.equals(MyApplication.getAppContext().getString(R.string.apadrinhar_pet)))
            return new PatronizeFragment();

        else if (screenName.equals(MyApplication.getAppContext().getString(R.string.chat)))
            return new ChatFragment();

        else if (screenName.equals(MyApplication.getAppContext().getString(R.string.favorties)))
            return new FavoriteFragment();

        else
            return null;
    }
}
