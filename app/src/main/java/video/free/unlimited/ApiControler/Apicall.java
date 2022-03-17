package video.free.unlimited.ApiControler;

import retrofit2.Call;
import retrofit2.http.GET;
import video.free.unlimited.Modal.VideoModal;
import video.free.unlimited.Modal.VideoModalapi;

public interface Apicall {

    @GET("api.php")
    Call<VideoModalapi> getvideo();

}
