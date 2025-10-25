package com.example.nimbus.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nimbus.R;

public class DetalhesCidadeActivity extends AppCompatActivity {

    private TextView tvTempMax, tvTempMin, tvTempDetails, tvDescDetails, tvWind, tvUmidade, tvPress, tvCityNameDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes_cidade);

        inicializarViews();

    }

    private void inicializarViews(){
        tvCityNameDetails = findViewById(R.id.tvCityNameDetails);
        tvTempDetails = findViewById(R.id.tvTempDetails);
        tvDescDetails = findViewById(R.id.tvDescDetails);
        tvTempMax = findViewById(R.id.tvTempMax);
        tvTempMin = findViewById(R.id.tvTempMin);
        tvUmidade = findViewById(R.id.tvUmidade);
        tvWind = findViewById(R.id.tvWind);
        tvPress = findViewById(R.id.tvPress);

    }
}