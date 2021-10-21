package com.example.ListViewCountries;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConversorXml parse=new ConversorXml(this);
        ListView lvPaises=findViewById(R.id.lvPaises);
        if(parse.parse()) {
            AdaptadorPaises adapter = new AdaptadorPaises(this, parse.getCountries());
            lvPaises.setAdapter(adapter);
        }
    }
}