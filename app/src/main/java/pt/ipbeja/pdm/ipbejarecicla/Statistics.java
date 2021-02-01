package pt.ipbeja.pdm.ipbejarecicla;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Statistics extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //SchoolSpinner
        Spinner schoolSpinner = findViewById(R.id.spinnerEscolas);
        ArrayAdapter<CharSequence> schoolSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinnerEscolas, android.R.layout.simple_spinner_item);
        schoolSpinner.setPrompt("Escola");
        schoolSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolSpinnerAdapter);
        schoolSpinner.setOnItemSelectedListener(this);


        //TypeOfUserSpinner
        Spinner typeOfUserSpinner = findViewById(R.id.spinnerTipoUtilizadores);
        ArrayAdapter<CharSequence> typeOfUserSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinnerTipoUtilizador, android.R.layout.simple_spinner_item);
        typeOfUserSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeOfUserSpinner.setAdapter(typeOfUserSpinnerAdapter);
        typeOfUserSpinner.setOnItemSelectedListener(this);

        //TypeOfMaterialSpinner
        Spinner typeOfMaterialSpinner = findViewById(R.id.spinnerTipoMaterial);
        ArrayAdapter<CharSequence> typeOfMaterialSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinnerTipoMaterial, android.R.layout.simple_spinner_item);
        typeOfMaterialSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeOfMaterialSpinner.setAdapter(typeOfMaterialSpinnerAdapter);
        typeOfMaterialSpinner.setOnItemSelectedListener(this);

        //CapacitySpinner
        Spinner capacitySpinner = findViewById(R.id.spinnerCapacidade);
        ArrayAdapter<CharSequence> capacitySpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinnerCapacidade, android.R.layout.simple_spinner_item);
        capacitySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        capacitySpinner.setAdapter(capacitySpinnerAdapter);
        capacitySpinner.setOnItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.mainToolBar);
        toolbar.setTitle("Estatísticas");
        setSupportActionBar(toolbar);

        /*
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Estatísticas");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        */
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}