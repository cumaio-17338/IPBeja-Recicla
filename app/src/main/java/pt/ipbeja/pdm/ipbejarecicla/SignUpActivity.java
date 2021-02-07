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
import com.google.firebase.auth.FirebaseAuth;
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
    private TextInputEditText emailEdit;
    private TextInputEditText nameEdit;
    private TextInputEditText passwordEdit;
    private String schoolEdit;
    private List<QueryDocumentSnapshot> academicCommunityUsers;
    private FirebaseFirestore mStore;
    private String type_of_user;
    private String school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();

        //Get data from firestore
        academicCommunityUsers = new ArrayList<>();
        academicCommunityUsers  = getAcademicCommunityUsers();

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
     * @return List of academic community users
     */
    private List<QueryDocumentSnapshot> getAcademicCommunityUsers() {

        List<QueryDocumentSnapshot> list = new ArrayList<>();

/*        mStore.collection("membrosComunidadeAcademica")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Successfully!", Toast.LENGTH_SHORT).show();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Toast.makeText(this, "Document: "+document.get("email"), Toast.LENGTH_SHORT).show();
                            list.add(document);
                            Toast.makeText(this, "Segundo toast!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, "Erro ao buscar dados dos membros da comunidade!", Toast.LENGTH_SHORT).show();
                    }
                });*/


        mStore.collection("membrosComunidadeAcademica")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
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
        }
        else if (v.getId() ==  R.id.btn_sign_up){
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
        }
        else  if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
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


        //Check if user belongs to academic community
        if(this.checkNewUser(email)){
            Toast.makeText(this, "Usuário registado, bem-vindo!", Toast.LENGTH_SHORT).show();
            this.registerNewUser(name, email, password);

            //Type of user is admin
            if(type_of_user.equals("administrador"))
            {
                Intent intent = new Intent(SignUpActivity.this, MainAdminActivity.class);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }

        }
        else {
            Toast.makeText(this, "Email inválido, tente novamente!", Toast.LENGTH_SHORT).show();
        }



    }

    /**
     * Register new user and send data to database
     * @param name
     * @param email
     * @param password
     */
    private void registerNewUser(String name, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        String userID = mAuth.getCurrentUser().getUid();

                        //Access document that belongs to user
                        DocumentReference documentReference = mStore.collection("usuarios").document(userID);
                        Map<String, Object> user = new HashMap<>();
                        user.put("nome", name);
                        user.put("email", email);
                        user.put("tipo_utilizador", type_of_user);
                        user.put("escola", school);
                        documentReference.set(user).addOnSuccessListener(aVoid -> Toast.makeText(SignUpActivity.this, "Utilizador criado com sucesso!", Toast.LENGTH_SHORT).show());
                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                        finish();
                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "Falha ao criar utilizador!", Toast.LENGTH_LONG).show();
                    }
                });
    }

    /**
     * Function to check if user belongs to academic community
     * @param email Email introduced by the user
     * @return Boolean value
     */
    private boolean checkNewUser(String email) {

        int q = academicCommunityUsers.size();
        Toast.makeText(this, "Size is: "+q, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < q; i++) {

            String var = academicCommunityUsers.get(i).get("email").toString();
            Log.d("TAG", "Usuario "+(i)+" "+var);
            if (email.equals(var))
            {
                type_of_user = academicCommunityUsers.get(i).get("tipo_utilizador").toString();
                school = academicCommunityUsers.get(i).get("escola").toString();

                Toast.makeText(this, email+":"+var, Toast.LENGTH_LONG).show();
                return true;
            }
            else {
                Toast.makeText(this, email+":"+var, Toast.LENGTH_LONG).show();
            }
        }

        return false;
    }
}