package com.example.nimbus.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nimbus.R;
import com.example.nimbus.adapter.CityHistoryAdapter;
import com.example.nimbus.model.City;
import com.example.nimbus.openWeatherApi.RetrofitCliente;
import com.example.nimbus.openWeatherApi.WeatherResponse;
import com.example.nimbus.openWeatherApi.interfaces.WeatherApiService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private TextView tvCityName, tvTemp, tvDescricao, tvTempMax, tvTempMin;
    private ImageView searchCity;
    private RecyclerView recyclerView;

    private static final String PREFS_NAME = "NimbusPrefs";
    private static final String KEY_LAST_CITY = "LastCity";
    private static final String KEY_CITY_HISTORY = "CityHistory";
    // MINHA CHAVE DA API
    private static final String API_KEY = "4a8809a3b95bbc7361ae42195f1ec859";

    private CityHistoryAdapter adapter;
    private List<City> cityList;
    private SharedPreferences prefs;
    private Gson gson;

    private ActivityResultLauncher<Intent> searchActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // inicializa as coisas
        initViews();
        initPrefsAndGson();
        initRecyclerView();

        setupSearchLauncher();
        loadDataFromPrefs();

        searchCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);

                searchActivityLauncher.launch(intent);
                Log.d("MainActivity", "voltou para a tela inicial");
            }
        });
    }

    private void initViews(){
        tvCityName = findViewById(R.id.tvCityName);
        tvTemp = findViewById(R.id.tvTemp);
        tvDescricao = findViewById(R.id.tvDescricao);
        tvTempMax = findViewById(R.id.tvTempMax);
        tvTempMin = findViewById(R.id.tvTempMin);
        searchCity = findViewById(R.id.searchCity);
        recyclerView = findViewById(R.id.recyclerView);
        Log.d("MainActivity", "inicializou atributos");
    }

    private void initPrefsAndGson(){
        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
        Log.d("MainActivity", "inicializou o GSON E PREFS");
    }

    private void initRecyclerView(){
        cityList = new ArrayList<>();
        adapter = new CityHistoryAdapter(cityList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        Log.d("MainActivity", "inicializou recyclerview");
    }

    private void setupSearchLauncher(){
        searchActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == MainActivity.RESULT_OK && result.getData() != null){
                        String cityName = result.getData().getStringExtra("City_name");
                        if(cityName != null && !cityName.isEmpty()){
                            fetchWeatherData(cityName);
                        }
                    }
                }
        );
    }
    private void fetchWeatherData(String cityName) {
        WeatherApiService service = RetrofitCliente.getService();
        Call<WeatherResponse> call = service.getCurrentWeather(cityName, API_KEY, "metric", "pt_br");

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, retrofit2.Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // 7. Conversão: API Response -> Objeto City
                    WeatherResponse apiData = response.body();
                    City city = convertResponseToCity(apiData);

                    // 8. Atualizar UI principal e salvar
                    updateMainUI(city);
                    saveLastCity(city);
                    addCityToHistory(city);
                    Log.d("MainActivity", "Atualizou o UI PRINCIPAL E SALVOU");
                } else {
                    Toast.makeText(MainActivity.this, "Cidade não encontrada.", Toast.LENGTH_SHORT).show();
                }
                Log.d("MainActivity", "método fetchWeatherData");
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha na rede: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private City convertResponseToCity(WeatherResponse apiData) {
        String nome = apiData.getName();
        String temp = String.format("%.0f°C", apiData.getMainApi().getTemperatura());
        String desc = apiData.getWeatherList().get(0).getDescricao();
        String wind = String.format("%.1f km/h", apiData.getWind().getSpeed());
        String max = String.format("%.0f°C", apiData.getMainApi().getTemp_max());
        String min = String.format("%.0f°C", apiData.getMainApi().getTemp_min());
        String press = String.format("%.0f hPa", apiData.getMainApi().getPressao());
        String hum = String.format("%.0f%%", apiData.getMainApi().getUmidade());

        Log.d("MainActivity", "converteu e criou classe city");
        return new City(nome, temp, desc, wind, max, min, press, hum);
    }

    private void updateMainUI(City city) {
        tvCityName.setText(city.getNome());
        tvTemp.setText(city.getTemp());
        tvDescricao.setText(city.getDescricao());
        tvTempMax.setText(city.getTemp_max());
        tvTempMin.setText(city.getTemp_min());
        Log.d("MainActivity", "Atualizou o UI");
    }

    private void saveLastCity(City city) {
        SharedPreferences.Editor editor = prefs.edit();
        String jsonCity = gson.toJson(city);
        editor.putString(KEY_LAST_CITY, jsonCity);
        editor.apply();
        Log.d("MainActivity", "SALVOU A ULTIMA CIDADE");
    }

    private void addCityToHistory(City city) {
        for (City c : cityList) {
            if (c.getNome().equals(city.getNome())) {
                cityList.remove(c);
                break;
            }
        }

        // Adiciona no topo da lista
        cityList.add(0, city);
        adapter.notifyDataSetChanged(); // Notifica o adapter da mudança

        // Salva a lista inteira no SharedPreferences
        SharedPreferences.Editor editor = prefs.edit();
        String jsonHistory = gson.toJson(cityList);
        editor.putString(KEY_CITY_HISTORY, jsonHistory);
        editor.apply();
        Log.d("MainActivity", "ADICIONOOU CIDADE");
    }

    private void loadDataFromPrefs() {
        // Carrega a última cidade
        String lastCityJson = prefs.getString(KEY_LAST_CITY, null);
        if (lastCityJson != null) {
            City lastCity = gson.fromJson(lastCityJson, City.class);
            updateMainUI(lastCity);
        }

        // Carrega o histórico
        String historyJson = prefs.getString(KEY_CITY_HISTORY, null);
        if (historyJson != null) {
            Type type = new TypeToken<ArrayList<City>>() {}.getType();
            List<City> loadedHistory = gson.fromJson(historyJson, type);
            if (loadedHistory != null) {
                cityList.addAll(loadedHistory);
                adapter.notifyDataSetChanged();
            }
        }
    }
}