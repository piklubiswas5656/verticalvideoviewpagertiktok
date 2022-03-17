package video.free.unlimited;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import video.free.unlimited.Adapter.VideoAdapter;
import video.free.unlimited.ApiControler.Apicontroler;
import video.free.unlimited.Modal.VideoModal;
import video.free.unlimited.Modal.VideoModalapi;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    VideoAdapter videoAdapter;
    Call<VideoModalapi> call;
    List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewPager2 = (ViewPager2) findViewById(R.id.viewpager);

        getdata();
    }

    private void getdata() {
        call = Apicontroler.getInstance().getapi().getvideo();
        call.enqueue(new Callback<VideoModalapi>() {
            @Override
            public void onResponse(Call<VideoModalapi> call, Response<VideoModalapi> response) {
                try {

                    data = response.body().getVideos();
                    videoAdapter = new VideoAdapter(data, getApplicationContext());
                    viewPager2.setAdapter(videoAdapter);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Server issue", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VideoModalapi> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "NO INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }


}