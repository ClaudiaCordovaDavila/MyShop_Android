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
import tecsup.edu.myshop_android.ResponseMessage;
import tecsup.edu.myshop_android.models.Producto;

/**
 * Created by CLAUDIA on 23/05/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://myshop-tecsup-claudia135.c9users.io/";

    @GET("api/v1/productos")
    Call<List<Producto>> getProductos();

    @FormUrlEncoded
    @POST("/api/v1/productos")
    Call<ResponseMessage> createProducto(@Field("nombre") String nombre,
                                         @Field("marca") String marca,
                                         @Field("direccion") String direccion,
                                         @Field("precio") String precio);

    @Multipart
    @POST("/api/v1/productos")
    Call<ResponseMessage> createProductoWithImage(
            @Part("nombre") RequestBody nombre,
            @Part("marca") RequestBody marca,
            @Part("direccion") RequestBody direccion,
            @Part("precio") RequestBody precio,
            @Part MultipartBody.Part imagen
    );
}
