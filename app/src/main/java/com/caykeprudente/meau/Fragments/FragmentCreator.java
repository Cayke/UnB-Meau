package com.caykeprudente.meau.Fragments;

import android.support.v4.app.Fragment;

import com.caykeprudente.meau.LoginActivity;
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
        {
            return new AdoptFragment();
        }
        else
            return null;
    }
}
