package tecsup.edu.myshop_android.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import tecsup.edu.myshop_android.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        // Init FirebaseAuth
        initFirebaseAuth();

        // Init FirebaseAuthStateListener
        initFirebaseAuthStateListener();
    }

    /**
     * Firebase Auth
     */
    private FirebaseAuth mAuth;

    private EditText emailInput;
    private EditText passwordInput;

    private void initFirebaseAuth(){
        // initialize the FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        emailInput = (EditText)findViewById(R.id.email_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
    }

    public void callLogin(View view){

        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        // Sign In user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmailAndPassword:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            Log.e(TAG, "signInWithEmailAndPassword:failed", task.getException());
                            Toast.makeText(MainActivity.this, "Username and/or password invalid", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void callRegistro(View view){

        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmailAndPassword:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            Log.e(TAG, "createUserWithEmailAndPassword:failed", task.getException());
                            Toast.makeText(MainActivity.this, "Register failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * Firebase AuthStateListener
     */
    private FirebaseAuth.AuthStateListener mAuthListener;

    private void initFirebaseAuthStateListener(){
        // and the AuthStateListener method so you can track whenever the user signs in or out
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());

                    Toast.makeText(MainActivity.this, "Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();

                    // Go MainActivity
                    startActivity(new Intent(MainActivity.this, BusquedaActivity.class));
                    finish();

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}