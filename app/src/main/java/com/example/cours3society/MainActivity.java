package com.example.cours3society;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String nom_employe="";
    private String telephone_employe="";
    private String societe="";
    private String adresse_societe = "";

    public static final int REQUETE_EMPLOYEE = 01;
    public static final int REQUETE_SOCIETY = 10;

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
        intent.putExtra("tel", telephone_employe);
        intent.putExtra("nom", nom_employe);

        startActivityForResult(intent, REQUETE_EMPLOYEE);
    }
    public void btnSocieteOnClick(View Source){
        if(nom_employe == null || nom_employe.length() ==0){
            Toast.makeText(this, "Veuillez saisir les données de l'employé avant cela", Toast.LENGTH_LONG ).show();
            return;
        }


        Intent intent = new Intent(this, SocietyActivity.class);
        intent.putExtra("message", "Veuillez saisir le nom de la société");
        intent.putExtra("societe", societe);
        intent.putExtra("adresse", adresse_societe);
        startActivityForResult(intent, REQUETE_SOCIETY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_CANCELED){
            return;
        }

        switch (requestCode){
            case REQUETE_EMPLOYEE:
                String nom = data.getExtras().getString("nomSaisi");
                String tel = data.getStringExtra("telSaisi");

                this.nom_employe =nom;
                this.telephone_employe = tel;

                TextView tvNom = findViewById(R.id.idNom);
                TextView tvTel = findViewById(R.id.idTelephone);

                tvNom.setText(nom);
                tvTel.setText(tel);
                break;
            case REQUETE_SOCIETY:
                String adresse = data.getExtras().getString("adresse");
                String societe = data.getStringExtra("societe");

                this.adresse_societe = adresse;
                this.societe = societe;

                TextView tvAdresse = findViewById(R.id.idAdresse);
                TextView tvSociete = findViewById(R.id.idSociete);

                tvAdresse.setText(adresse);
                tvSociete.setText(societe);
                break;
            default:
                Toast.makeText(this, "Activité non prise en compte par MainActivity", Toast.LENGTH_LONG).show();
                break;


        }
    }
}
