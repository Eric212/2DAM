package com.example.ListViewCountries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Locale;

public class AdaptadorPaises extends ArrayAdapter<Country> {
    private Country[] paises;
    public AdaptadorPaises(@NonNull Context context, Country[] paises) {
        super(context,R.layout.listitem_country,paises);
        this.paises=paises;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View layout = convertView;
        ViewHolderPaises viewHolder;

        if(layout == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            layout = inflater.inflate(R.layout.listitem_country, null);
            viewHolder = new ViewHolderPaises();
            viewHolder.tCountry = layout.findViewById(R.id.tCountry);
            viewHolder.tCapital = layout.findViewById(R.id.tCapital);
            viewHolder.tPoblacion = layout.findViewById(R.id.tPoblacion);
            viewHolder.iFlag=layout.findViewById(R.id.iFlag);
            layout.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderPaises) layout.getTag();
        }
        Country pais = paises[position];
        viewHolder.tCountry.setText(pais.getCountryName());
        viewHolder.tCapital.setText("Capital: "+pais.getCountryCapital());
        viewHolder.tPoblacion.setText("Poblacion: "+Long.toString(pais.getCountryPopulation()));
        if(layout.getContext().getResources().getIdentifier("_"+paises[position].getCountryCode().toLowerCase(Locale.ROOT),"drawable",layout.getContext().getPackageName())!=0) {
            viewHolder.iFlag.setImageResource(layout.getContext().getResources().getIdentifier("_" + paises[position].getCountryCode().toLowerCase(Locale.ROOT), "drawable", layout.getContext().getPackageName()));
        }else {
            viewHolder.iFlag.setImageResource(R.mipmap.ic_launcher);
        }
        return layout;
    }


    static class ViewHolderPaises {
        TextView tCountry;
        TextView tCapital;
        TextView tPoblacion;
        ImageView iFlag;
    }
}
