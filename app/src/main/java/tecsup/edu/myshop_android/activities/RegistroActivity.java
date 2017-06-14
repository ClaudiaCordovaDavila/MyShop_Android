package tecsup.edu.myshop_android.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import tecsup.edu.myshop_android.R;

public class RegistroActivity extends AppCompatActivity {

    EditText nombre, username, apellido;
    Button crear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
}
