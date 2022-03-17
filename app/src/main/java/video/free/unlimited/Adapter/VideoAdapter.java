package video.free.unlimited.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import video.free.unlimited.Modal.VideoModal;
import video.free.unlimited.Modal.VideoModalapi;
import video.free.unlimited.R;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.holder> {
    List<String> data;
    Context context;

    public VideoAdapter(List<String>data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singallayout, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
//
        String videourl = data.get(position);
        holder.videoView.setVideoPath(videourl);

//        // finding videoview by its id
//        VideoView videoView = findViewById(R.id.videoView);
//
//        // Uri object to refer the
//        // resource from the videoUrl
//        Uri uri = Uri.parse(videoUrl);
//
//        // sets the resource from the
//        // videoUrl to the videoView
//        videoView.setVideoURI(uri);
//
//        // creating object of
//        // media controller class
//        MediaController mediaController = new MediaController(this);
//
//        // sets the anchor view
//        // anchor view for the videoView
//        mediaController.setAnchorView(videoView);
//
//        // sets the media player to the videoView
//        mediaController.setMediaPlayer(videoView);
//
//        // sets the media controller to the videoView
//        videoView.setMediaController(mediaController);
//
//        // starts the video
//        videoView.start();


//
//        MediaController mediaController = new MediaController(context);
//        mediaController.setAnchorView(holder.videoView);
//        holder.videoView.setMediaController(mediaController);
//        holder.videoView.start();

        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                holder.progressBar.setVisibility(View.GONE);
                mediaPlayer.start();
            }
        });
        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        VideoView videoView;
        ProgressBar progressBar;

        public holder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }
    }
}
