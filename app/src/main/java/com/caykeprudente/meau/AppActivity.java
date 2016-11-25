package com.caykeprudente.meau;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;

import com.caykeprudente.meau.Fragments.AnimalFragment;
import com.caykeprudente.meau.Fragments.FragmentCreator;
import com.caykeprudente.meau.Fragments.LegislacaoFragment;
import com.caykeprudente.meau.Fragments.RegisterAnimalFragment;
import com.caykeprudente.meau.Fragments.TermoAdocaoFragment;
import com.caykeprudente.meau.Models.Pet;

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
        this.userPhoto.setImageResource(R.drawable.user_image);
        this.userBackground.setImageResource(R.drawable.ic_user_background_first);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.my_profile), R.drawable.profile);
        mHelpLiveo.add(getString(R.string.my_pets), R.drawable.dog);
        mHelpLiveo.add(getString(R.string.favorties), R.drawable.like);
        mHelpLiveo.addSeparator();

        mHelpLiveo.addSubHeader(getString(R.string.shortcut));
        mHelpLiveo.add(getString(R.string.register_pet), R.drawable.icon_register);
        mHelpLiveo.add(getString(R.string.adopt_pet), R.drawable.icon_adopt);
        mHelpLiveo.add(getString(R.string.help_pet), R.drawable.icon_help);
        mHelpLiveo.add(getString(R.string.apadrinhar_pet), R.drawable.icon_apadrinhar);
        mHelpLiveo.add(getString(R.string.chat), R.drawable.icon_chat);
        mHelpLiveo.addSeparator();

        mHelpLiveo.addSubHeader(getString(R.string.info));
        mHelpLiveo.add(getString(R.string.tips_row), R.drawable.icon_tip);
        mHelpLiveo.add(getString(R.string.events), R.drawable.icon_event);
        mHelpLiveo.add(getString(R.string.legislation), R.drawable.icon_law);
        mHelpLiveo.add(getString(R.string.terms), R.drawable.icon_term);
        mHelpLiveo.add(getString(R.string.history), R.drawable.icon_story);
        mHelpLiveo.addSeparator();

//        mHelpLiveo.addSubHeader(getString(R.string.config));
//        mHelpLiveo.add(getString(R.string.privacity), R.drawable.icon_privacy);
//        mHelpLiveo.addSeparator();

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
        }
        else if (screen.equals("Cadastrar um pet")) {
            Fragment mFragment = FragmentCreator.newInstance(screen);

            if (mFragment != null) {
                ((RegisterAnimalFragment) mFragment).mainFragmentManager = mFragmentManager;
                mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
            }
        } else if (screen.equals("Termo de adoção")) {
            Fragment mFragment = FragmentCreator.newInstance(screen);

            if (mFragment != null) {
                ((TermoAdocaoFragment) mFragment).mainFragmentManager = mFragmentManager;
                mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
            }
        } else if (screen.equals("Legislação")) {
            Fragment mFragment = FragmentCreator.newInstance(screen);

            if (mFragment != null) {
                ((LegislacaoFragment) mFragment).mainFragmentManager = mFragmentManager;
                mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
            }
        }
        else {
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


    public void switchToAnimalFragment(Pet pet) {
        Fragment mFragment = new AnimalFragment(pet);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.container, mFragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount == 0) {
            //do nothing
        } else {
            super.onBackPressed();
        }
    }
}
