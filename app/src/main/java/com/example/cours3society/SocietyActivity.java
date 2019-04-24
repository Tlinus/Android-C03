package com.example.cours3society;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    }

    public void btnOkOnClick(View source) {

    }
    public void btnAnnulerOnClick(View source) {
        finish();
    }
}
