package com.example.zetc0de.uts_android;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tampil_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_activity);

        // Set Title Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Data Mahasiswa");

        Intent intent = getIntent();
        String namaDepan = intent.getStringExtra("Nama Depan");
        String namaBelakang = intent.getStringExtra("Nama Belakang");
        String nim = intent.getStringExtra("NIM");
        String email = intent.getStringExtra("EMAIL");

        // TextView
        TextView tnamaDepan = findViewById(R.id.TNamaDepan);
        TextView tnamaBelakang = findViewById(R.id.TnamaBelakang);
        TextView tNIM = findViewById(R.id.TNIM);
        TextView tEmail = findViewById(R.id.TEMAIL);

        // Set Text
        tnamaDepan.setText(namaDepan);
        tnamaBelakang.setText(namaBelakang);
        tNIM.setText(nim);
        tEmail.setText(email);

        // Button Go Home
        Button btnHome = findViewById(R.id.goHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome = new Intent(tampil_activity.this,MainActivity.class);
                startActivity(gohome);
            }
        });

        // Button Go Exit
        Button btnExit = findViewById(R.id.goExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exit
                finish();
                moveTaskToBack(true);
            }
        });
    }
}
