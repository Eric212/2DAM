package com.germangascon.testviewholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private final int N_ALUMNOS = 100;
    private Alumno[] alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvAlumnos = findViewById(R.id.lvAlumnos);
        generarAlumnos(N_ALUMNOS);

        AlumnoAdapter adapter = new AlumnoAdapter(this, alumnos);
        lvAlumnos.setAdapter(adapter);
    }

    private void generarAlumnos(int nAlumnos) {
        alumnos = new Alumno[nAlumnos];
        for(int i = 0; i < nAlumnos; i++) {
            alumnos[i] = new Alumno(String.valueOf(i), "Nombre" + i, "Apellidos" +i);
        }
    }
}