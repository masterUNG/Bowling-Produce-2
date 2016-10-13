package appewtc.masterung.bowlingproduce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class VideoListView extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private String[] strings = new String[]{"วีดีโอที่ 1", "วีดีโอที่ 2", "วีดีโอที่ 3"};
    private int[] ints = new int[]{R.drawable.video1,
            R.drawable.video2, R.drawable.video3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list_view);

        listView = (ListView) findViewById(R.id.livShowVideo);

        Log.d("13octV2", "title video lng ==> " + strings.length);

        VideoAdapter videoAdapter = new VideoAdapter(VideoListView.this, strings, ints);
        listView.setAdapter(videoAdapter);


    }   // Main Method

}   // Main Class
