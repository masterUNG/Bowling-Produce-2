package appewtc.masterung.bowlingproduce;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;


public class ShowListProduct extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private String categoryString;
    private TextView textView;
    private ListView listView;
    private Button button;
    private String urlJSONString;
    private String[] catStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_product);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView8);
        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);

        //Get Value from Intent
        urlJSONString = getIntent().getStringExtra("urlJSON");
        categoryString = getIntent().getStringExtra("Category");

        //Show Text
        textView.setText(categoryString);

        //Button Controller
        button.setOnClickListener(this);

        //Setup urlJSON

        //MainActivity mainActivity = new MainActivity();
       // catStrings = mainActivity.getCatStrings();

//        if (    categoryString.equals(catStrings[0])) {
//            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat1_master.php";
//        } else if (categoryString.equals(catStrings[1])) {
//            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat2_master.php";
//        } else if (categoryString.equals(catStrings[2])) {
//            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat3_master.php";
//        } else if (categoryString.equals(catStrings[3])) {
//            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat4_master.php";
//        } else if (categoryString.equals(catStrings[4])) {
//            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat5_master.php";
//        } else if (categoryString.equals(catStrings[5])) {
//            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat6_master.php";
//        } else if (categoryString.equals(catStrings[6])) {
//            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat7_master.php";
//        } else {
//            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat8_master.php";
//        }

        //Create ListView by Data on Server
        SynProduce synProduce = new SynProduce(this, listView, urlJSONString);
        synProduce.execute();

    }   // Main Method

    private class SynProduce extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private ListView myListView;
        private String myUrlJSONString;

        public SynProduce(Context context,
                          ListView myListView,
                          String myUrlJSONString) {
            this.context = context;
            this.myListView = myListView;
            this.myUrlJSONString = myUrlJSONString;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(myUrlJSONString).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                return null;
            }

        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("BowlingV1", "JSON ===> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);
                final String[] titleStrings = new String[jsonArray.length()];
                final String[] descripStrings = new String[jsonArray.length()];
                String[] descripShortStrings = new String[jsonArray.length()];
                final String[] priceStrings = new String[jsonArray.length()];
                final String[] iconStrings = new String[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i+=1) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    titleStrings[i] = jsonObject.getString("Product");
                    descripStrings[i] = jsonObject.getString("Description");
                    descripShortStrings[i] = descripStrings[i].substring(0, 30) + "...";
                    priceStrings[i] = jsonObject.getString("Price") + " บาท";
                    iconStrings[i] = jsonObject.getString("Image");

                }   // for

                ProduceAdapter produceAdapter = new ProduceAdapter(context,
                        titleStrings, descripShortStrings, priceStrings, iconStrings);
                myListView.setAdapter(produceAdapter);
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(ShowListProduct.this, DetailActivity.class);
                        intent.putExtra("Title", titleStrings[position]);
                        intent.putExtra("Icon", iconStrings[position]);
                        intent.putExtra("Descrip", descripStrings[position]);
                        intent.putExtra("Price", priceStrings[position]);
                        startActivity(intent);


                    }   // On Item Click
                });

            } catch (Exception e) {
                e.printStackTrace();
            }


        }   // onPost

    }   // SynProduct


    @Override
    public void onClick(View view) {
        finish();
    }
}   // Main Class
