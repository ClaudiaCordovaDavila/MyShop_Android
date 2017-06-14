package tecsup.edu.myshop_android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import tecsup.edu.myshop_android.ImagenActivity;
import tecsup.edu.myshop_android.R;
import tecsup.edu.myshop_android.adapters.ProductosAdapter;
import tecsup.edu.myshop_android.interfaces.ApiService;
import tecsup.edu.myshop_android.models.Producto;
import tecsup.edu.myshop_android.singleton.ApiServiceGenerator;

import static tecsup.edu.myshop_android.R.id.nombre_detalle;

public class DetalleActivity extends AppCompatActivity {

    private static final String TAG = DetalleActivity.class.getSimpleName();
    private Integer id;
    public ImageView imagenDetalle;
    public TextView nombreDetalle;
    public TextView marcaDetalle;
    public TextView tiendaDetalle;
    public TextView precioDetalle;
    public TextView direccionDetalle;
    public TextView telefonoDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imagenDetalle = (ImageView) findViewById(R.id.imagen_detalle);
        nombreDetalle = (TextView) findViewById(R.id.nombre_detalle);
        marcaDetalle = (TextView) findViewById(R.id.marca_detalle);
        tiendaDetalle = (TextView) findViewById(R.id.tienda_detalle);
        precioDetalle = (TextView) findViewById(R.id.precio_detalle);
        direccionDetalle = (TextView) findViewById(R.id.direccion_detalle);
        telefonoDetalle = (TextView) findViewById(R.id.telefono_detalle);

        id = (Integer)getIntent().getExtras().get("id");
        Log.d("DetalleActivity", "id: "  + id);

        // Llamar al servicio show
        initialize();


        //Visualizar Imagen
        final ImageView imageView = (ImageView) findViewById(R.id.imagen_detalle);

        final String uri = "http://www.gloria.com.pe/images/gloria/evaporada_entera_022.jpg";

        Picasso.with(this)
                .load(uri)
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagenActivity.start(DetalleActivity.this, uri, imageView);
            }
        });
    }

    private void initialize() {

        String nombre = nombreDetalle.getText().toString();

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Producto>> call = service.buscarProductos(nombre);

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Producto> productos = response.body();
                        Log.d(TAG, "productos: " + productos);

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(DetalleActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(DetalleActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void map(View view){
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}

