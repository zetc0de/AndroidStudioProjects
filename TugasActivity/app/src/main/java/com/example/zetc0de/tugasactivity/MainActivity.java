package com.example.zetc0de.tugasactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Deklarasi komponen
    Button btnClose,btnStartActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inisialisasi komponen
        btnClose = (Button) findViewById(R.id.btn_close);
        btnStartActivity = (Button) findViewById(R.id.btn_start_activity);

        btnClose.setOnClickListener(this);
        btnStartActivity.setOnClickListener(this);

        Toast.makeText(this,"Activity: onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Activity: onStart()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this,"Activity: onResume()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this,"Activity: onPause()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this,"Activity: onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_activity:
                Intent bukaKiblat = new Intent(Intent.ACTION_VIEW);
                bukaKiblat.setData(Uri.parse("https://www.kiblat.net/"));
                startActivity(bukaKiblat);
                break;
            case R.id.btn_close:
                finish();
                break;

        }
    }
}
