package tecsup.edu.myshop_android.interfaces;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import tecsup.edu.myshop_android.ResponseMessage;
import tecsup.edu.myshop_android.models.Producto;

/**
 * Created by CLAUDIA on 23/05/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://myshop-android-claudia135.c9users.io/";

    @GET("api/v1/productos")
    Call<List<Producto>> getProductos();

    @GET("api/v1/productos/{id}")
    Call<Producto> getProducto(@Path("id") Integer id);

    @FormUrlEncoded
    @POST("api/v1/productos/buscar")
    Call<List<Producto>> buscarProductos(@Field("nombre") String nombre);

}
