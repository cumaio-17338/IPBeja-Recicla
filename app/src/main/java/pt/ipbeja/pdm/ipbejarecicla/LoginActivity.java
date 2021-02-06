package pt.ipbeja.pdm.ipbejarecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tst;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        tst =  findViewById(R.id.textView_signup);

        tst.setOnClickListener(this);
        btn_login.setOnClickListener(this);

    }
    

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.textView_signup){
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

        } else if (v.getId() == R.id.btn_login){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }
}