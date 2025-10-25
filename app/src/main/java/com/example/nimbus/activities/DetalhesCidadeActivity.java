package com.example.nimbus.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nimbus.R;
import com.example.nimbus.model.City;

public class DetalhesCidadeActivity extends AppCompatActivity {

    private TextView tvTempMax, tvTempMin, tvTempDetails, tvDescDetails, tvWind, tvUmidade, tvPress, tvCityNameDetails;
    private ImageView btnVoltarDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes_cidade);

        inicializarViews();

        City city = (City) getIntent().getSerializableExtra("City_DATA");

        if(city != null){
            preencerUI(city);
        }else{
            Toast.makeText(this, "Erro ao carregar os detalhes da cidade", Toast.LENGTH_SHORT).show();
        }

        btnVoltarDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
        btnVoltarDetails = findViewById(R.id.btnVoltarDetails);
    }

    private void preencerUI(City city){
        tvCityNameDetails.setText(city.getNome());
        tvTempMax.setText(city.getTemp_max());
        tvTempMin.setText(city.getTemp_min());
        tvDescDetails.setText(city.getDescricao());
        tvPress.setText(city.getPressure());
        tvTempDetails.setText(city.getTemp());
        tvUmidade.setText(city.getHumidity());
        tvWind.setText(city.getWindSpeed());
    }
}