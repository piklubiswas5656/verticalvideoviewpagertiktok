package video.free.unlimited.ApiControler;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apicontroler {

    private static Apicontroler clintObject;
    private static Retrofit retrofit;


    public Apicontroler() {

//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
//                .callTimeout(60, TimeUnit.MINUTES)
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .writeTimeout(60, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
                .build();
    }

    public static synchronized Apicontroler getInstance() {
        if (clintObject == null) {
            clintObject = new Apicontroler();
        }

        return clintObject;
    }

    public Apicall getapi() {

        return retrofit.create(Apicall.class);

    }
}
