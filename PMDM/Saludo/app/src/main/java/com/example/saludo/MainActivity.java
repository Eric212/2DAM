package com.example.saludo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nombre=findViewById(R.id.eName);
        EditText apellido=findViewById(R.id.eSurName);
        Button saluda=findViewById(R.id.bSaluda);
        saluda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Saludos "+nombre.getText()+" "+apellido.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}