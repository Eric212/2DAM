package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IAlumnosListener {

    private ArrayList<Alumno> alumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generarAlumnos(100);
        RecyclerView rwAlumnos=findViewById(R.id.rvAlumno);
        rwAlumnos.setHasFixedSize(true);
        rwAlumnos.setAdapter(new AdaptadorAlumnos(alumnos,this));
        //rwAlumnos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        rwAlumnos.setLayoutManager(new GridLayoutManager(this,4));
    }
    public void generarAlumnos(int nAlumnos){
        alumnos=new ArrayList<>(nAlumnos);
        for (int i=0;i<nAlumnos;i++){
            String nombre="Nombre"+i;
            String apellido="Apellido"+i;
            alumnos.add(new Alumno(nombre,apellido));
        }
    }

    @Override
    public void onClickAlumno(int position) {
        Alumno a=alumnos.get(position);
        Toast.makeText(getApplicationContext(),a.getNombre()+" "+a.getApellidos(),Toast.LENGTH_LONG).show();
    }
}