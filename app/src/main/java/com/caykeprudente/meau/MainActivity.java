package com.caykeprudente.meau;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_adopt, btn_register, btn_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_adopt = (Button) findViewById(R.id.activity_main_btn_adopt);
        btn_help = (Button) findViewById(R.id.activity_main_btn_help);
        btn_register = (Button) findViewById(R.id.activity_main_btn_register);


        btn_adopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AppActivity.class);
                intent.putExtra("initial_screen", getString(R.string.adopt_pet));
                startActivity(intent);
                finish();
            }
        });

        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AppActivity.class);
                intent.putExtra("initial_screen", getString(R.string.help_pet));
                startActivity(intent);
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AppActivity.class);
                intent.putExtra("initial_screen", getString(R.string.register_pet));
                startActivity(intent);
                finish();
            }
        });
    }
}
