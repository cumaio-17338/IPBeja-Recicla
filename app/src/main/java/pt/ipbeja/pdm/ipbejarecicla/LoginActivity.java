package pt.ipbeja.pdm.ipbejarecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextView tst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tst =  findViewById(R.id.textView_signup);
        tst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSignupActivity(v);
            }
        });
    }

    public void callSignupActivity(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}