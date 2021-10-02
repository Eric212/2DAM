package com.example.caracruz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imagen=findViewById(R.id.iImagen);
        Button cara=findViewById(R.id.bCara);
        Button cruz=findViewById(R.id.bCruz);
        TextView resultado=findViewById(R.id.tResultado);
        cara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado(new String("cara"),imagen,resultado);
            }
        });
        cruz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado(new String("cruz"),imagen,resultado);
            }
        });
    }
    private void resultado(String ladoMoneda,ImageView imagen,TextView resultado){
        switch (ladoMoneda) {
            case "cara":
                if (new Random().nextInt(2) + 1 == 1) {
                    imagen.setImageResource(R.mipmap.cara_foreground);
                    imagen.setContentDescription("Euro face");
                    resultado.setText("Has ganado");
                } else {
                    imagen.setImageResource(R.mipmap.cruz_foreground);
                    imagen.setContentDescription("Euro cross");
                    resultado.setText("Has perdido");
                }
            break;
            case "cruz":
                if (new Random().nextInt(2) + 1 == 1) {
                    imagen.setImageResource(R.mipmap.cruz_foreground);
                    imagen.setContentDescription("Euro cross");
                    resultado.setText("Has ganado");
                } else {
                    imagen.setImageResource(R.mipmap.cara_foreground);
                    imagen.setContentDescription("Euro face");
                    resultado.setText("Has perdido");
                }
            break;
            default:
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }
    }
}