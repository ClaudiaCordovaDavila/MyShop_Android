package tecsup.edu.myshop_android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tecsup.edu.myshop_android.R;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
    }

    public void map(View view){
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}

