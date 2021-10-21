package com.example.factorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText numero=findViewById(R.id.eFactorial);
        TextView resultado=findViewById(R.id.tResultado);
        Button calcula=findViewById(R.id.bCalcula);
        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x=1;
                try{
                    for(int i=Integer.parseInt(numero.getText().toString());i>0;i--){
                        x*=i;
                    }
                    resultado.setText(Integer.toString(x));
                }catch (InputMismatchException ex){
                    Toast.makeText(getApplicationContext(),"Error, dato no valido",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}