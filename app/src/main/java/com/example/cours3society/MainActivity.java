package com.example.cours3society;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String nom_employe="";
    private String telephone_employe="";
    private String societe="";
    private String adresse_societe = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.idNom);
        tv.setText(nom_employe);
        tv = findViewById(R.id.idTelephone);
        tv.setText(telephone_employe);
        tv = findViewById(R.id.idSociete);
        tv.setText(societe);
        tv = findViewById(R.id.idAdresse);
        tv.setText(adresse_societe);
    }

    public void btnEmployeOnClick(View Source){
        Intent intent = new Intent(this, EmployeeActivity.class);
        intent.putExtra("message", "Veuillez saisir le nom et le téléphone de l'employé");
        startActivityForResult(intent, 1);
    }
    public void btnSocieteOnClick(View Source){
        Intent intent = new Intent(this, SocietyActivity.class);
        intent.putExtra("message", "Veuillez saisir le nom de la société");
        startActivityForResult(intent, 1);
    }
}
