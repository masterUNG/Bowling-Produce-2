package appewtc.masterung.bowlingproduce;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Main2Activity extends AppCompatActivity {

    //Explicit
    private String urlJSoN = "http://203.147.24.71/ars/get_cat.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView = (ListView) findViewById(R.id.livShowCat);

        //Create ListView
        SynCat synCat = new SynCat(Main2Activity.this);
        synCat.execute(urlJSoN);

    }   // Main Method

    private class SynCat extends AsyncTask<String, Void, String> {

        //Explicit
        private Context context;

        public SynCat(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strings[0]).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("13octV1", "e doInBack ==> " + e.toString());
                return null;
            }

        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("13octV1", "JSON ==> " + s);

        }   // onPost

    }   // SynCat Class


}   // Main Class
