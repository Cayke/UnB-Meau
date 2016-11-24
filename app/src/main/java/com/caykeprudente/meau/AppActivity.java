package com.caykeprudente.meau;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;

import com.caykeprudente.meau.Fragments.AnimalFragment;
import com.caykeprudente.meau.Fragments.FragmentCreator;
import com.caykeprudente.meau.Fragments.RegisterAnimalFragment;

import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.model.HelpLiveo;
import br.liveo.model.Navigation;
import br.liveo.navigationliveo.NavigationLiveo;

/**
 * Created by cayke on 03/11/16.
 */

public class AppActivity extends NavigationLiveo implements OnItemClickListener {
    private HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String screen = intent.getStringExtra("initial_screen");
        int position = 0;
        if (screen.equals(getString(R.string.adopt_pet)))
            position = 6;
        else if (screen.equals(getString(R.string.register_pet)))
            position = 5;
        else if (screen.equals(getString(R.string.help_pet)))
            position = 7;

        // User Information
        this.userName.setText("Cayke Prudente");
        this.userEmail.setText("cayke10@gmail.com");
        this.userPhoto.setImageResource(R.drawable.user_male);
        this.userBackground.setImageResource(R.drawable.ic_user_background_first);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.my_profile), R.drawable.profile);
        mHelpLiveo.add(getString(R.string.my_pets), R.drawable.dog);
        mHelpLiveo.add(getString(R.string.favorties), R.drawable.like);
        mHelpLiveo.addSeparator();

        mHelpLiveo.addSubHeader(getString(R.string.shortcut));
        mHelpLiveo.add(getString(R.string.register_pet), R.drawable.help);
        mHelpLiveo.add(getString(R.string.adopt_pet), R.drawable.help);
        mHelpLiveo.add(getString(R.string.help_pet), R.drawable.help);
        mHelpLiveo.add(getString(R.string.apadrinhar_pet), R.drawable.help);
        mHelpLiveo.add(getString(R.string.chat), R.drawable.help);
        mHelpLiveo.addSeparator();

        mHelpLiveo.addSubHeader(getString(R.string.info));
        mHelpLiveo.add(getString(R.string.tips_row), R.drawable.help);
        mHelpLiveo.add(getString(R.string.events), R.drawable.help);
        mHelpLiveo.add(getString(R.string.legislation), R.drawable.help);
        mHelpLiveo.add(getString(R.string.terms), R.drawable.help);
        mHelpLiveo.add(getString(R.string.history), R.drawable.help);
        mHelpLiveo.addSeparator();

        mHelpLiveo.addSubHeader(getString(R.string.config));
        mHelpLiveo.add(getString(R.string.privacity), R.drawable.help);
        mHelpLiveo.addSeparator();

        //with(this, Navigation.THEME_DARK). add theme dark
        //with(this, Navigation.THEME_LIGHT). add theme light

        with(this, Navigation.THEME_LIGHT) // default theme is dark
                .startingPosition(position) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(getString(R.string.exit), R.drawable.exit)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();
    }

    @Override
    public void onItemClick(int position) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        String screen = mHelpLiveo.get(position).getName();

        //todo apagar isso, era so pra poder mostrar o login
        if (screen.equals(getString(R.string.my_profile))) {
            Intent intent = new Intent(AppActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (screen.equals("Cadastrar um pet")) {
            Fragment mFragment = FragmentCreator.newInstance(screen);

            if (mFragment != null) {
                ((RegisterAnimalFragment) mFragment).mainFragmentManager = mFragmentManager;
                mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
            }
        } else {
            Fragment mFragment = FragmentCreator.newInstance(screen);

            if (mFragment != null) {
                mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
            }
        }
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };


    public void switchToAnimalFragment() {
        Fragment mFragment = AnimalFragment.newInstance("", "");
        FragmentManager mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.container, mFragment).addToBackStack(null).commit();
    }
}
