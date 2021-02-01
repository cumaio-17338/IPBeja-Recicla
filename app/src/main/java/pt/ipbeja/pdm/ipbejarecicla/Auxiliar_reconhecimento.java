package pt.ipbeja.pdm.ipbejarecicla;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Auxiliar_reconhecimento extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auxiliar_reconhecimento_layout);



        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CapacitySpinner
        Spinner capacitySpinner = findViewById(R.id.spinner_capacidade);
        ArrayAdapter<CharSequence> schoolSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_capacidade, android.R.layout.simple_spinner_item);
        capacitySpinner.setPrompt("Capacidade");
        schoolSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        capacitySpinner.setAdapter(schoolSpinnerAdapter);
        capacitySpinner.setOnItemSelectedListener(this);


        //TypeSpinner
        Spinner typeSpinner = findViewById(R.id.spinner_tipo);
        ArrayAdapter<CharSequence> typeOfUserSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_tipo, android.R.layout.simple_spinner_item);
        typeOfUserSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeOfUserSpinnerAdapter);
        typeSpinner.setOnItemSelectedListener(this);

        //DescriptionSpinner
        Spinner descriptionSpinner = findViewById(R.id.spinner_descrição);
        ArrayAdapter<CharSequence> typeOfMaterialSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_descrição, android.R.layout.simple_spinner_item);
        typeOfMaterialSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        descriptionSpinner.setAdapter(typeOfMaterialSpinnerAdapter);
        descriptionSpinner.setOnItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.auxiliar_reconhecimento_ToolBar);
        toolbar.setTitle("Auxiliar Reconhecimento");
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
