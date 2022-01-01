package com.yesilusame.ortalamabulma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextVize, editTextVizeYuzde, editTextFinal, editTextFinalYuzde, editTextOdev, editTextOdevYuzde;
    TextView textViewSonuc;
    Button button;
    DecimalFormat decimalFormat;
    double sonuc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initComponents();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewSonuc.setVisibility(View.VISIBLE);
                if ((editTextVize.getText().toString().equals("") || editTextVize.getText() == null)
                        || (editTextOdev.getText().toString().equals("") || editTextOdev.getText() == null)
                        || (editTextFinal.getText().toString().equals("") || editTextFinal.getText() == null)
                ) {
                    uyari("Hatalı Giriş !");
                }
                else {
                    if (((Double.parseDouble(editTextVize.getText().toString())) + (Double.parseDouble(editTextOdev.getText().toString())) + (Double.parseDouble(editTextFinal.getText().toString()))) >= 100) {
                        uyari("Hatalı Giriş !");
                    } else {
                        sonuc = ((Double.parseDouble(editTextVize.getText().toString())
                                *
                                (Double.parseDouble(editTextVizeYuzde.getText().toString()))) / 100)
                                +
                                ((Double.parseDouble(editTextOdev.getText().toString())
                                        *
                                        (Double.parseDouble(editTextOdevYuzde.getText().toString()))) / 100)
                                +
                                ((Double.parseDouble(editTextFinal.getText().toString())
                                        *
                                        (Double.parseDouble(editTextFinalYuzde.getText().toString()))) / 100);

                        textViewSonuc.setText("Ortalamanız: " + decimalFormat.format(sonuc));
                    }
                }
            }
        });

    }

    private void initComponents() {
        editTextVize = findViewById(R.id.vizeNotu);
        editTextVizeYuzde = findViewById(R.id.vizeYuzde);
        editTextOdev = findViewById(R.id.odevNotu);
        editTextOdevYuzde = findViewById(R.id.odevYuzde);
        editTextFinal = findViewById(R.id.finalNotu);
        editTextFinalYuzde = findViewById(R.id.finalYuzdesi);
        textViewSonuc = findViewById(R.id.sonuc);
        button = findViewById(R.id.hesapla);
        decimalFormat = new DecimalFormat("00.00");
    }

    private void uyari(String Mesaj) {
        Toast.makeText(getApplicationContext(), Mesaj, Toast.LENGTH_SHORT).show();
    }
}