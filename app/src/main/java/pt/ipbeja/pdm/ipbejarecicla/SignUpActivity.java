package pt.ipbeja.pdm.ipbejarecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Spinner schoolSpinner = findViewById(R.id.spinner_escolas_signup);
        ArrayAdapter<CharSequence> schoolSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinnerEscolas, android.R.layout.simple_spinner_item);
        schoolSpinner.setPrompt("Escola");
        schoolSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolSpinnerAdapter);
        schoolSpinner.setOnItemSelectedListener(this);


        tst =  findViewById(R.id.textView_login);
        tst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLoginActivity(v);
            }
        });
    }


    public void callLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}