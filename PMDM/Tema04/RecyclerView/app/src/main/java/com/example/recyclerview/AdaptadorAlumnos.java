package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorAlumnos extends RecyclerView.Adapter<AdaptadorAlumnos.AlumnosViewHolder> {
    private IAlumnosListener listener;
    private ArrayList<Alumno> alumnos;
    public AdaptadorAlumnos(ArrayList<Alumno> alumnos, MainActivity mainActivity){
        this.alumnos=alumnos;
    }

    @NonNull
    @Override
    public AlumnosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemalumno, parent,false);
        return new AlumnosViewHolder(item,listener);
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnosViewHolder holder, int position) {
        holder.bindAlumno(alumnos.get(position));
    }


    public static class AlumnosViewHolder extends RecyclerView.ViewHolder implements IAlumnosListener {
        private final TextView tvNombre;
        private final TextView tvApellido;
        private IAlumnosListener listener;
        public AlumnosViewHolder(@NonNull View itemView, IAlumnosListener listener) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellido = itemView.findViewById(R.id.tvApellido);
            this.listener=listener;
        }

        public void bindAlumno(Alumno a) {
            tvNombre.setText(a.getNombre());
            tvApellido.setText(a.getApellidos());
        }

        @Override
        public void onClickAlumno(int position) {
            if(listener!=null){
                listener.onClickAlumno(getAdapterPosition());
            }
        }
    }
}
