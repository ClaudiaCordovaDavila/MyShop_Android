package tecsup.edu.myshop_android.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import tecsup.edu.myshop_android.R;
import tecsup.edu.myshop_android.interfaces.ApiService;
import tecsup.edu.myshop_android.models.Producto;
import tecsup.edu.myshop_android.models.Tienda;

/**
 * Created by CLAUDIA on 23/05/2017.
 */

public class DetallesAdapter extends RecyclerView.Adapter<DetallesAdapter.ViewHolder> {

    private List<Producto> productos;

    private  List<Tienda> tiendas;

    public DetallesAdapter(){
        this.productos = new ArrayList<>();
        this.tiendas = new ArrayList<>();
    }

    public void setProductos(List<Producto> productos){
        this.productos = productos;
    }

    public void setTiendas(List<Tienda> tiendas){
        this.tiendas = tiendas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imagenDetalle;
        public TextView nombreDetalle;
        public TextView marcaDetalle;
        public TextView tiendaDetalle;
        public TextView precioDetalle;
        public TextView direccionDetalle;
        public TextView telefonoDetalle;

        public ViewHolder(View itemView) {
            super(itemView);
            imagenDetalle = (ImageView) itemView.findViewById(R.id.imagen_detalle);
            nombreDetalle = (TextView) itemView.findViewById(R.id.nombre_detalle);
            marcaDetalle = (TextView) itemView.findViewById(R.id.marca_detalle);
            tiendaDetalle = (TextView) itemView.findViewById(R.id.tienda_detalle);
            precioDetalle = (TextView) itemView.findViewById(R.id.precio_detalle);
            direccionDetalle = (TextView) itemView.findViewById(R.id.direccion_detalle);
            telefonoDetalle = (TextView) itemView.findViewById(R.id.telefono_detalle);
        }
    }

    @Override
    public DetallesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalle, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetallesAdapter.ViewHolder viewHolder, int position) {

        Producto producto = this.productos.get(position);
        Tienda tienda = this.tiendas.get(position);

        viewHolder.nombreDetalle.setText(producto.getNombre());
        viewHolder.marcaDetalle.setText(producto.getMarca());
        viewHolder.tiendaDetalle.setText(producto.getTienda());
        viewHolder.precioDetalle.setText("S/. " + producto.getPrecio());
        viewHolder.direccionDetalle.setText(tienda.getDireccion());
        viewHolder.telefonoDetalle.setText(tienda.getTelefono());

        String url = ApiService.API_BASE_URL + "/images/" + producto.getImagen();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.imagenDetalle);

    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
