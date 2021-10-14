package com.germangascon.testviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class AlumnoAdapter extends ArrayAdapter<Alumno> {

    private Alumno[] alumnos;

    public AlumnoAdapter(@NonNull Context context, Alumno[] alumnos) {
        super(context, R.layout.list_item_alumnos, alumnos);
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View layout = convertView;
        ViewHolderAlumno viewHolder;

        if(layout == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            layout = inflater.inflate(R.layout.list_item_alumnos, null);
            viewHolder = new ViewHolderAlumno();
            viewHolder.tvNia = layout.findViewById(R.id.tvNia);
            viewHolder.tvNombre = layout.findViewById(R.id.tvNombre);
            viewHolder.tvApellidos = layout.findViewById(R.id.tvApellidos);
            layout.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderAlumno) layout.getTag();
        }
        Alumno alumno = alumnos[position];
        viewHolder.tvNia.setText(alumno.getNia());
        viewHolder.tvNombre.setText(alumno.getNombre());
        viewHolder.tvApellidos.setText(alumno.getApellidos());
        return layout;
    }


    static class ViewHolderAlumno {
        TextView tvNia;
        TextView tvNombre;
        TextView tvApellidos;
    }

}


