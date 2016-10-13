package appewtc.masterung.bowlingproduce;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ShowVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        MediaController mediaController = new MediaController(ShowVideoActivity.this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" +
                getPackageName() + "/" + getIntent().getIntExtra("Video", R.raw.master_ung)));
        videoView.start();

    }   // Main Method

}   // Main Class
