package video.free.unlimited;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

import video.free.unlimited.Adapter.VideoAdapter;
import video.free.unlimited.Modal.VideoModal;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewPager2 = (ViewPager2) findViewById(R.id.viewpager);
        videoAdapter = new VideoAdapter(stroedate(), getApplicationContext());
        viewPager2.setAdapter(videoAdapter);
    }

    private ArrayList<VideoModal> stroedate() {
        ArrayList<VideoModal> holder = new ArrayList<>();
        VideoModal obj1 = new VideoModal("https://cdn.sharechat.com/cv-1ec428b8_1647288366060_sc.mp4");
        holder.add(obj1);
        VideoModal obj2 = new VideoModal("https://cdn.sharechat.com/cv-243a8ee4_1647035834106_sc.mp4");
        holder.add(obj2);
        VideoModal obj3 = new VideoModal("https://cdn.sharechat.com/cv-1ec428b8_1647288366060_sc.mp4");
        holder.add(obj3);
        VideoModal obj4 = new VideoModal("https://cdn.sharechat.com/cv-243a8ee4_1647035834106_sc.mp4");
        holder.add(obj4);
        VideoModal obj5 = new VideoModal("https://cdn.sharechat.com/cv-1ec428b8_1647288366060_sc.mp4");
        holder.add(obj5);

        return holder;
    }
}