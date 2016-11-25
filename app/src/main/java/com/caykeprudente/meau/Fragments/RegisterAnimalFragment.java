package com.caykeprudente.meau.Fragments;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.caykeprudente.meau.AppActivity;
import com.caykeprudente.meau.Models.MainData;
import com.caykeprudente.meau.Models.Pet;
import com.caykeprudente.meau.R;


public class RegisterAnimalFragment extends Fragment {

    protected static Boolean selectAdoption = false;
    protected static Boolean selectApadrinhar = false;
    protected static Boolean selectHelp = false;
    private static View mainView;
    public static FragmentManager mainFragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_register_animal, container, false);
        this.mainView = view;

        final Context mContext = view.getContext();
        ((AppActivity) getActivity()).getSupportActionBar().setTitle("Cadastro de Animal");

        CheckBox checkboxExigenciasAuxilio = (CheckBox) view.findViewById(R.id.exigencias_apadrinhamento_auxilio);
        checkboxExigenciasAuxilio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    view.findViewById(R.id.exigencias_apadrinhamento_auxilio_alimentacao).setEnabled(true);
                    view.findViewById(R.id.exigencias_apadrinhamento_auxilio_objetos).setEnabled(true);
                    view.findViewById(R.id.exigencias_apadrinhamento_auxilio_saude).setEnabled(true);
                } else {
                    view.findViewById(R.id.exigencias_apadrinhamento_auxilio_alimentacao).setEnabled(false);
                    view.findViewById(R.id.exigencias_apadrinhamento_auxilio_objetos).setEnabled(false);
                    view.findViewById(R.id.exigencias_apadrinhamento_auxilio_saude).setEnabled(false);
                }
            }
        });

        final Button buttonAdoption = (Button) view.findViewById(R.id.adoptionChoice);
        final Button buttonApadrinhar = (Button) view.findViewById(R.id.apadrinharChoice);
        final Button buttonHelper = (Button) view.findViewById(R.id.helpChoice);
        final LinearLayout apadrinhamentoContent = (LinearLayout) view.findViewById(R.id.register_animal_exigencias_apadrinhamento);

        apadrinhamentoContent.setVisibility(View.GONE);

        buttonAdoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAdoption = !selectAdoption;
                if (selectAdoption) {
                    v.setBackgroundColor(Color.parseColor("#ffd358")); // escuro
                    if (selectApadrinhar) {
                        buttonApadrinhar.performClick();
                    }
                    apadrinhamentoContent.setVisibility(View.GONE);
                } else {
                    v.setBackgroundColor(Color.parseColor("#f1f2f2")); // claro
                }
            }
        });
        buttonApadrinhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectApadrinhar = !selectApadrinhar;
                if (selectApadrinhar) {
                    v.setBackgroundColor(Color.parseColor("#ffd358"));
                    if (selectAdoption) {
                        buttonAdoption.performClick();
                    }
                    apadrinhamentoContent.setVisibility(View.VISIBLE);
                } else {
                    v.setBackgroundColor(Color.parseColor("#f1f2f2")); // claro
                }
            }
        });
        buttonHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectHelp = !selectHelp;
                if (selectHelp) {
                    v.setBackgroundColor(Color.parseColor("#ffd358"));
                } else {
                    v.setBackgroundColor(Color.parseColor("#f1f2f2")); // claro
                }
            }
        });

        final Button buttonCreate = (Button) view.findViewById(R.id.register_send);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAnimal(v, mContext);
            }
        });

        return view;
    }

    public void createAnimal (View view, Context context) {
        RadioButton explicitRadio = null;
        String nome = ((EditText) mainView.findViewById(R.id.register_animal_name)).getText().toString();

        explicitRadio = (RadioButton) mainView.findViewById(((RadioGroup) mainView.findViewById(R.id.especie_choice)).getCheckedRadioButtonId());
        if (explicitRadio==null) {Toast.makeText(context, "Dados a preencher!", Toast.LENGTH_LONG).show();return;}
        String especie = explicitRadio.getText().toString();

        explicitRadio = (RadioButton) mainView.findViewById(((RadioGroup) mainView.findViewById(R.id.gender_choice)).getCheckedRadioButtonId());
        if (explicitRadio==null) {Toast.makeText(context, "Dados a preencher!", Toast.LENGTH_LONG).show();return;}
        String genero = explicitRadio.getText().toString();

        explicitRadio = (RadioButton) mainView.findViewById(((RadioGroup) mainView.findViewById(R.id.porte_choice)).getCheckedRadioButtonId());
        if (explicitRadio==null) {Toast.makeText(context, "Dados a preencher!", Toast.LENGTH_LONG).show();return;}
        String porte = explicitRadio.getText().toString();

        explicitRadio = (RadioButton) mainView.findViewById(((RadioGroup) mainView.findViewById(R.id.age_choice)).getCheckedRadioButtonId());
        if (explicitRadio==null) {Toast.makeText(context, "Dados a preencher!", Toast.LENGTH_LONG).show();return;}
        String idade = explicitRadio.getText().toString();


        if (nome.isEmpty() || especie.isEmpty() || genero.isEmpty() || porte.isEmpty() || idade.isEmpty()) {
            Toast.makeText(context, "Dados a preencher!", Toast.LENGTH_LONG).show();
            return;
        }

        CheckBox explicitCheckBox = null;
        // temperamento
        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.temp_sel_brinc);
        Boolean brincalhao = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());

        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.temp_sel_timido);
        Boolean timido = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());

        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.temp_sel_calmo);
        Boolean calmo = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());

        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.temp_sel_guarda);
        Boolean guarda = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());

        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.temp_sel_amoroso);
        Boolean amoroso = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());

        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.temp_sel_pregui);
        Boolean preguicoso = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());


        // saude
        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.saude_sel_vacinado);
        Boolean vacinado = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());
        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.saude_sel_verminfugado);
        Boolean verminfugado = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());
        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.saude_sel_castrado);
        Boolean castrado = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());
        explicitCheckBox = (CheckBox) mainView.findViewById(R.id.saude_sel_doente);
        Boolean doente = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());

        if (selectApadrinhar) {
            explicitCheckBox = (CheckBox) mainView.findViewById(R.id.exigencias_apadrinhamento_termo);
            Boolean termo = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());
            explicitCheckBox = (CheckBox) mainView.findViewById(R.id.exigencias_apadrinhamento_auxilio_alimentacao);
            Boolean auxAlimentacao = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());
            explicitCheckBox = (CheckBox) mainView.findViewById(R.id.exigencias_apadrinhamento_auxilio_saude);
            Boolean auxSaude = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());
            explicitCheckBox = (CheckBox) mainView.findViewById(R.id.exigencias_apadrinhamento_auxilio_objetos);
            Boolean auxObjetos = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());
            explicitCheckBox = (CheckBox) mainView.findViewById(R.id.exigencias_apadrinhamento_visitas);
            Boolean visitas = ((explicitCheckBox==null) ? false : explicitCheckBox.isChecked());
        }

        String sobre = ((EditText) mainView.findViewById(R.id.register_animal_about)).getText().toString();

        // ignorando as fotos
        // TODO: 22/11/16 inserir dados do animal em um documento
        // TODO: 22/11/16 inserir documento em um array
        Pet newPet = new Pet(nome, genero, idade, porte, "", R.drawable.toto, true, especie);
        MainData.getInstance().pushPet(newPet);

        // trocar fragment para sucesso!
        mainFragmentManager.beginTransaction().replace(R.id.container, new SuccessRegisterFragment()).commit();
    }
}
