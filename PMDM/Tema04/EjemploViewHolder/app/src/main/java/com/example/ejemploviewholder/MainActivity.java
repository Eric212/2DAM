package com.example.ejemploviewholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private final int N_ALUMNOS=100;
    private Alumno[] alumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generarAlumnos(N_ALUMNOS);
        ListView lvAlumnos=findViewById(R.id.lvApellidos);
        AlumnoAdapter adapter=new AlumnoAdapter(this,alumnos);
        lvAlumnos.setAdapter(adapter);
    }
    private void generarAlumnos(int nAlumnos){
        alumnos=new Alumno[nAlumnos];
        for (int i=0;i<alumnos.length;i++){
            alumnos[i]=new Alumno(String.valueOf(i),"nombre"+i,"apellidos"+i);
        }
    }
}