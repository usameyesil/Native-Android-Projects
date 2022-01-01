package com.yesilusame.projectbeginnerone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextisim, editTextboy, editTextkilo;
    Button button;
    String[] stringListe;
    Double[] doubleList;
    TextView textView;
    DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appbarOrtala();
        initComponents();
        button.setOnClickListener(view -> {
            textView.setVisibility(View.VISIBLE);
            textView.setText("");
            yaziEkle();
            sonuc();

        });
    }

    private void appbarOrtala() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.appbarlayout);
    }

    private void initComponents() {
        editTextisim = findViewById(R.id.isimSoyisimGir);
        editTextboy = findViewById(R.id.boyGir);
        editTextkilo = findViewById(R.id.kiloGir);
        button = findViewById(R.id.hesapla);
        textView = findViewById(R.id.sonuc);
        stringListe = new String[4];
        doubleList = new Double[3];
        decimalFormat = new DecimalFormat("00.00");
    }

    private void sonuc() {
        textView.append("Sayın " + stringListe[0] + "," + "\n");
        textView.append("Boyunuz: " + stringListe[1] + "\n");
        textView.append("Kilonuz: " + stringListe[2] + "\n");
        textView.append("Boy Kilo Endeksiniz: " + decimalFormat.format(doubleList[2]) + "\n");
        textView.append("Durumunuz: " + kiloDurumu(doubleList[2]));
    }

    private String kiloDurumu(double d) {
        if (d <= 18.5)
            stringListe[3] = "Düşük Kilolu";
        else if (d > 18.5 && d <= 24.9)
            stringListe[3] = "Normal";
        else if (d > 24.9 && d <= 29.9)
            stringListe[3] = "Fazla Kilolu";
        else if (d > 29.9 && d <= 40)
            stringListe[3] = "Obez";
        else if (d > 40)
            stringListe[3] = "Aşırı Obez";


        return stringListe[3];
    }

    private void yaziEkle() {
        stringListe[0] = editTextisim.getText().toString();
        stringListe[1] = editTextboy.getText().toString();
        stringListe[2] = editTextkilo.getText().toString();
        doubleList[0] = (!stringListe[1].equals("")) ? ((Double.parseDouble(stringListe[1])) / 100) : -1;
        doubleList[1] = (!stringListe[2].equals("")) ? (Double.parseDouble(stringListe[2])) : -1;
        doubleList[2] = doubleList[1] / (doubleList[0] * doubleList[0]);
        if (doubleList[0] == -1 || doubleList[1] == -1) {
            uyari("Hatalı Giriş !");
        }
    }

    private void uyari(String Mesaj) {
        Toast.makeText(getApplicationContext(), Mesaj, Toast.LENGTH_SHORT).show();

    }

}