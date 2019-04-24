package com.example.cours3society;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SocietyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_society);

        Intent intent = getIntent();
        String msg = intent.getExtras().getString("message");

        TextView tv = findViewById(R.id.idMessage);
        tv.setText(msg);

        EditText etAdresse = findViewById(R.id.idAdresse);
        etAdresse.setText(intent.getExtras().getString("adresse"));

        EditText etSoc = findViewById(R.id.idSociete);
        etSoc.setText(intent.getExtras().getString("tel"));
    }

    public void btnOkOnClick(View source) {

        String adresseSaisi = ((EditText) findViewById(R.id.idAdresse)).getText().toString().trim();
        String scoSaisi = ((EditText) findViewById(R.id.idSociete)).getText().toString().trim();

        Intent intent = new Intent();
        intent.putExtra("adresse", adresseSaisi);
        intent.putExtra("societe", scoSaisi);

        // Informer la main activity que la saisi est valide et doit être utilisé :*
        // et envoyé les données de intent;
        setResult(RESULT_OK, intent);


        finish();

    }
    public void btnAnnulerOnClick(View source) {

        setResult(RESULT_CANCELED);
        finish();
    }
}
