package com.example.nimbus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nimbus.R;
import com.example.nimbus.model.City;

import java.util.List;

public class CityHistoryAdapter extends RecyclerView.Adapter<CityHistoryAdapter.ViewHolder> {

    private List<City> cities;
    private Context context;

    public CityHistoryAdapter(List<City> cities, Context context) {
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override // infla o XML do item
    public CityHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_city_history, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityHistoryAdapter.ViewHolder holder, int position) {
        City city = cities.get(position);
        holder.cityName.setText(city.getNome());
        holder.cityDesc.setText(city.getDescricao());
        holder.cityTemp.setText(city.getTemp());

    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView cityName, cityDesc, cityTemp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
