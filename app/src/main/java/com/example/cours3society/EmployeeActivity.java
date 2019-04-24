package com.example.cours3society;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_employee);

        Intent intent = getIntent();
        String msg = intent.getExtras().getString("message");
        TextView tv = findViewById(R.id.idMessage);
        tv.setText(msg);

        EditText etName = findViewById(R.id.idNom);
        etName.setText(intent.getExtras().getString("nom"));

        EditText etTel = findViewById(R.id.idTelephone);
        etTel.setText(intent.getExtras().getString("tel"));
    }
    public void btnOkOnClick(View source){
        String nomSaisi = ((EditText) findViewById(R.id.idNom)).getText().toString().trim();
        String telSaisi = ((EditText) findViewById(R.id.idTelephone)).getText().toString().trim();

        Intent intent = new Intent();
        intent.putExtra("telSaisi", telSaisi);
        intent.putExtra("nomSaisi", nomSaisi);

        // Informer la main activity que la saisi est valide et doit être utilisé :*
        // et envoyé les données de intent;
        setResult(RESULT_OK, intent);


        finish();
    }
    public void btnAnnulerOnClick(View source){
        setResult(RESULT_CANCELED);
        finish();
    }
}
