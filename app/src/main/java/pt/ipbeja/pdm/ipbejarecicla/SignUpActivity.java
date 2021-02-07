package pt.ipbeja.pdm.ipbejarecicla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    TextView tst;
    Button btn_signup;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mStore;
    private TextInputEditText emailEdit;
    private TextInputEditText nameEdit;
    private TextInputEditText passwordEdit;
    private String schoolEdit;
    private List<QueryDocumentSnapshot> academicCommunityMembers;
    private String type_of_user;
    private String school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();

        Spinner schoolSpinner = findViewById(R.id.spinner_escolas_signup);
        ArrayAdapter<CharSequence> schoolSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinnerEscolas, android.R.layout.simple_spinner_item);
        schoolSpinner.setPrompt("Escola");
        schoolSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolSpinnerAdapter);
        schoolSpinner.setOnItemSelectedListener(this);

        btn_signup = findViewById(R.id.btn_sign_up);
        tst = findViewById(R.id.textView_login);

        tst.setOnClickListener(this);
        btn_signup.setOnClickListener(this);


        emailEdit = findViewById(R.id.input_email);
        nameEdit = findViewById(R.id.input_full_name);
        passwordEdit = findViewById(R.id.input_password);
    }

    /**
     * Function to get and return the list of community users
     *
     * @return List of academic community users
     */
    private List<QueryDocumentSnapshot> getAcademicCommunityMembers() {

        List<QueryDocumentSnapshot> list = new ArrayList<>();

       mStore.collection("membrosComunidadeAcademica")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.get("email"));
                                list.add(document);
                                
                            }
                        } else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });
        return list;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        schoolEdit = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.textView_login) {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.btn_sign_up) {
            registerUser();
        }
    }

    /**
     * Function to register user
     */
    private void registerUser() {
        String email = emailEdit.getText().toString().trim();
        String name = nameEdit.getText().toString().trim();
        String password = passwordEdit.getText().toString().trim();


        //Validate data
        if (email.isEmpty()) {
            emailEdit.setError("Por favor, insira o seu email!");
            emailEdit.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEdit.setError("Por favor insira um email válido!");
            emailEdit.requestFocus();
            return;
        }

        if (name.isEmpty()) {
            nameEdit.setError("Por favor, insira o seu nome!");
            nameEdit.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEdit.setError("Por favor, insira a palavra-passe!");
            passwordEdit.requestFocus();
            return;
        }

        school = "ESTIG";
        createNewUser(email, password, name, school);

    }

    private void createNewUser(String email, String password, String name, String school) {
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "User created on F. Auth!", Toast.LENGTH_SHORT).show();
                        String userID = mAuth.getCurrentUser().getUid();

                        //Access document that belongs to user
                        DocumentReference documentReference = mStore.collection("users").document(userID);
                        Map<String, Object> user = new HashMap<>();
                        user.put("name", name);
                        user.put("email", email);
                        user.put("escola", school);
                        documentReference.set(user).addOnSuccessListener(aVoid -> Toast.makeText(SignUpActivity.this, "Usuário criado com sucesso!", Toast.LENGTH_LONG).show());

                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "Erro ao criar usuário!", Toast.LENGTH_LONG).show();
                    }
                });
    }


}