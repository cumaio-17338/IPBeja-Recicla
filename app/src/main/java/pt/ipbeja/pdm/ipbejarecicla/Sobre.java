package pt.ipbeja.pdm.ipbejarecicla;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class Sobre extends AppCompatActivity {

    private TabLayout tabLayout; //to put the green toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre_layout);

        //to put the green toolbar
        Toolbar toolbar = findViewById(R.id.mainToolBar);
        toolbar.setTitle(R.string.sobre);
        setSupportActionBar(toolbar);

    }

}