package com.example.paiseslistview;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class PaisAdapter extends ArrayAdapter<Pais> {
    public PaisAdapter(@NonNull Context context, @NonNull Pais[] paises) {
        super(context,R.layout.lisitem_country,paises);
    }
}
