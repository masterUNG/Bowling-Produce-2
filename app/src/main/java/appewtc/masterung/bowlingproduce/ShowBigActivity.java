package appewtc.masterung.bowlingproduce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ShowBigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_big);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);

        Picasso.with(ShowBigActivity.this)
                .load(getIntent().getStringExtra("Icon"))
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }   // Main Method

}   // Main Class
