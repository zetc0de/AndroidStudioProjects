package com.example.zetc0de.uts_android;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Input Data Mahasiswa");

        // EditText
        final EditText TnamaDepan = findViewById(R.id.input_nama_depan);
        final EditText TnamaBelakang = findViewById(R.id.input_nama_belakang);
        final EditText Tnim = findViewById(R.id.input_nim);
        final EditText Temail = findViewById(R.id.input_email);

        // Input Button
        Button submit = findViewById(R.id.btn_input);

        // Button click listener
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data
                String namaDepan = TnamaDepan.getText().toString();
                String namaBelakang = TnamaBelakang.getText().toString();
                String nim = Tnim.getText().toString();
                String email = Temail.getText().toString();

                // Activity Intent
                Intent intent = new Intent(MainActivity.this,tampil_activity.class);
                intent.putExtra("Nama Depan", namaDepan);
                intent.putExtra("Nama Belakang", namaBelakang);
                intent.putExtra("NIM",nim);
                intent.putExtra("EMAIL",email);
                startActivity(intent);
            }
        });

        Button btnClear = findViewById(R.id.clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TnamaDepan.getText().clear();
                TnamaBelakang.getText().clear();
                Tnim.getText().clear();
                Temail.getText().clear();
            }
        });



    }
}
