package com.example.nimbus.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nimbus.R;

public class SearchActivity extends AppCompatActivity {

    private EditText editTextSearchCity;
    private Button buttonSearch;
    private ImageView btnVoltar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        // 1. Encontrar os componentes do layout
        editTextSearchCity = findViewById(R.id.editTextSearchCity);
        buttonSearch = findViewById(R.id.buttonSearch);
        btnVoltar = findViewById(R.id.btnVoltar);

        // 2. Definir o clique do botão "Pesquisar"
        buttonSearch.setOnClickListener(v -> {
            String cityName = editTextSearchCity.getText().toString().trim();

            if (cityName.isEmpty()) {
                Toast.makeText(this, "Por favor, digite um nome de cidade.", Toast.LENGTH_SHORT).show();
            } else {
                // Se o texto não estiver vazio, envia o resultado de volta
                sendResultBack(cityName);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SearchActivity", "VOLTOU");
                finish();
            }
        });
    }

    private void sendResultBack(String cityName) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("City_name", cityName);
        setResult(Activity.RESULT_OK, resultIntent);
        Log.d("SearchActivity", "ENVIOU O RESULTADO");
        finish();
    }
}
