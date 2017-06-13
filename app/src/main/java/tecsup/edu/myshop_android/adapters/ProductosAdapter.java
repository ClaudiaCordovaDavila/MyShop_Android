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

/**
 * Created by CLAUDIA on 23/05/2017.
 */

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder> {

    private List<Producto> productos;

    public ProductosAdapter(){
        this.productos = new ArrayList<>();
    }

    public void setProductos(List<Producto> productos){
        this.productos = productos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView fotoImage;
        public TextView nombreText;
        public TextView marcaText;
        public TextView tiendaText;
        public TextView precioText;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoImage = (ImageView) itemView.findViewById(R.id.foto_image);
            nombreText = (TextView) itemView.findViewById(R.id.nombre_text);
            marcaText = (TextView) itemView.findViewById(R.id.marca_text);
            tiendaText = (TextView) itemView.findViewById(R.id.tienda_text);
            precioText = (TextView) itemView.findViewById(R.id.precio_text);
        }
    }

    @Override
    public ProductosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductosAdapter.ViewHolder viewHolder, int position) {

        Producto producto = this.productos.get(position);

        viewHolder.nombreText.setText(producto.getNombre());
        viewHolder.marcaText.setText(producto.getMarca());
        viewHolder.tiendaText.setText(producto.getTienda());
        viewHolder.precioText.setText("S/. " + producto.getPrecio());

        String url = ApiService.API_BASE_URL + "/images/" + producto.getImagen();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
