package pt.ipbeja.pdm.ipbejarecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity{

    CardView impacts, learn_more, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.mainToolBar);
        learn_more = findViewById(R.id.cardView_learn_more);
        impacts = findViewById(R.id.cardView_impacts);
        impacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Impacts.class);
                startActivity(intent);
            }
        });

        learn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SaberMais.class));
            }
        });

        toolbar.setTitle("Olá, Utilizador");
        setSupportActionBar(toolbar);



        //"Sobre"- button action
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Sobre.class));
            }
        });

        //"Sobre"- button action

    }

}