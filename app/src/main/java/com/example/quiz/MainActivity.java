package com.example.quiz;

import static android.view.View.INVISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> pytania;

    private ImageView imageView;

    private Button buttonTak, buttonNie, buttonDalej;

    private TextView textView;

    private int aktualne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dodajPytania();
        textView = findViewById(R.id.textView2);
        buttonTak = findViewById(R.id.button);
        buttonNie = findViewById(R.id.button4);
        buttonDalej = findViewById(R.id.button12);
        imageView = findViewById(R.id.imageView);
        wypiszPytanie(0);
        buttonDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aktualne++;
                if(aktualne == pytania.size()) {
                    buttonDalej.setVisibility(INVISIBLE);
                    //TODO: wypisywanie wyniku
                }
                else {
                    wypiszPytanie(aktualne);
                }
            }
        });
    }
    private void wypiszPytanie(int ktore){
        Pytanie pytanko = pytania.get(ktore);
        textView.setText(pytanko.getTrescPytania());
        imageView.setImageResource((int)pytanko.getIdZdjecia());
    }
    private void dodajPytania() {
        pytania = new ArrayList<>();
        pytania.add(new Pytanie(R.drawable.tygrys, "Czy tygrys to fajny kotek?", true));
        pytania.add(new Pytanie(R.drawable.slon, "Czy slon spi na stojac?",false));
        pytania.add(new Pytanie(R.drawable.myszojelen, "czy myszojelen jest goated?",true));
        pytania.add(new Pytanie(R.drawable.papuga, "czy papuga lata pod woda?",false));
        pytania.add(new Pytanie(R.drawable.kot, "czy kot szczeka?",false));
    }
}