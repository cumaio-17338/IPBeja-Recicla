package pt.ipbeja.pdm.ipbejarecicla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView impacts, learn_more, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.mainToolBar);
        learn_more = findViewById(R.id.cardView_learn_more);
        impacts = findViewById(R.id.cardView_impacts);
        about = findViewById(R.id.cardView_impacts);

        impacts.setOnClickListener(this);
        learn_more.setOnClickListener(this);
        about.setOnClickListener(this);

        toolbar.setTitle("Olá, Utilizador");
        setSupportActionBar(toolbar);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cardView_impacts) {
            Intent intent = new Intent(MainActivity.this, Impacts.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardView_learn_more) {
            Intent intent = new Intent(MainActivity.this, SaberMais.class);
            startActivity(intent);
        }   else if (v.getId() == R.id.cardView_about) {
        Intent intent = new Intent(MainActivity.this, SaberMais.class);
        startActivity(intent);
    }
    }
}