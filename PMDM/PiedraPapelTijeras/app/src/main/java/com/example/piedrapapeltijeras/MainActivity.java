package com.example.piedrapapeltijeras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button stone = findViewById(R.id.bStone);
        Button paper = findViewById(R.id.bPaper);
        Button scissors = findViewById(R.id.bScissors);
        ImageView iPlayer = findViewById(R.id.iPlayer);
        ImageView iCpu = findViewById(R.id.iCpu);
        TextView resultado = findViewById(R.id.tResult);
        stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] resultados = {"Has ganado", "Has perdido", "Has empatado", "Error"};
                String[] cpu = {"Piedra", "Tijeras", "Papel"};
                String comodin = cpu[new Random().nextInt(3)];
                int ganador;
                if(view.getId()==R.id.bStone) {
                    iPlayer.setImageResource(R.mipmap.istone_foreground);
                    ganador=resultado("Piedra", comodin);
                    if(ganador==0){
                        iCpu.setImageResource(R.mipmap.iscissors_foreground);
                    }else if(ganador==1){
                        iCpu.setImageResource(R.mipmap.ipaper_foreground);
                    }else{
                        iCpu.setImageResource(R.mipmap.istone_foreground);
                    }
                    resultado.setText(resultados[ganador]);
                }
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] resultados = {"Has ganado", "Has perdido", "Has empatado", "Error"};
                String[] cpu = {"Piedra", "Tijeras", "Papel"};
                String comodin = cpu[new Random().nextInt(3)];
                int ganador;
                if (view.getId()==R.id.bPaper) {
                    iPlayer.setImageResource(R.mipmap.ipaper_foreground);
                    ganador=resultado("Papel", comodin);
                    if(ganador==0){
                        iCpu.setImageResource(R.mipmap.istone_foreground);
                    }else if(ganador==1){
                        iCpu.setImageResource(R.mipmap.iscissors_foreground);
                    }else{
                        iCpu.setImageResource(R.mipmap.ipaper_foreground);
                    }
                    resultado.setText(resultados[ganador]);
                }
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] resultados = {"Has ganado", "Has perdido", "Has empatado", "Error"};
                String[] cpu = {"Piedra", "Tijeras", "Papel"};
                String comodin = cpu[new Random().nextInt(3)];
                int ganador;
                if(view.getId()==R.id.bScissors) {
                    iPlayer.setImageResource(R.mipmap.iscissors_foreground);
                    ganador=resultado("Tijeras", comodin);
                    if(ganador==0){
                        iCpu.setImageResource(R.mipmap.ipaper_foreground);
                    }else if(ganador==1){
                        iCpu.setImageResource(R.mipmap.istone_foreground);
                    }else{
                        iCpu.setImageResource(R.mipmap.iscissors_foreground);
                    }
                    resultado.setText(resultados[ganador]);
                }
            }
        });
    }
    private int resultado(String player, String cpu) {
        switch (player) {
            case "Piedra":
                if (cpu.equals("Tijeras")) {
                    return 0;
                } else if (cpu.equals("Papel")) {
                    return 1;
                } else {
                    return 2;
                }
            case "Tijeras":
                if (cpu.equals("Papel")) {
                    return 0;
                } else if (cpu.equals("Piedra")) {
                    return 1;
                } else {
                    return 2;
                }
            case "Papel":
                if (cpu.equals("Piedra")) {
                    return 0;
                } else if (cpu.equals("Tijeras")) {
                    return 1;
                } else {
                    return 2;
                }
            default:
                return 3;
        }
    }
}