package appewtc.masterung.bowlingproduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class VideoListView extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private String[] strings = new String[]{"วีดีโอที่ 1", "วีดีโอที่ 2", "วีดีโอที่ 3"};
    private int[] ints = new int[]{R.drawable.video1,
            R.drawable.video2, R.drawable.video3};
    private int[] videoInts = new int[]{R.raw.master_ung,
            R.raw.football, R.raw.master_ung};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list_view);

        listView = (ListView) findViewById(R.id.livShowVideo);

        Log.d("13octV2", "title video lng ==> " + strings.length);

        VideoAdapter videoAdapter = new VideoAdapter(VideoListView.this, strings, ints);
        listView.setAdapter(videoAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(VideoListView.this, ShowVideoActivity.class);
                intent.putExtra("Video", videoInts[i]);
                startActivity(intent);


            }
        });


    }   // Main Method

}   // Main Class
