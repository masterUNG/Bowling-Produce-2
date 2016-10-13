package appewtc.masterung.bowlingproduce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 10/13/2016 AD.
 */

public class CatAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleString, iconString;

    public CatAdapter(Context context,
                      String[] titleString,
                      String[] iconString) {
        this.context = context;
        this.titleString = titleString;
        this.iconString = iconString;
    }

    @Override
    public int getCount() {
        return titleString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.cat_listview, viewGroup, false);

        //Bind Widget
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView11);
        TextView textView = (TextView) view1.findViewById(R.id.textView17);

        //Show View
        Picasso.with(context).load(iconString[i]).into(imageView);
        textView.setText(titleString[i]);

        return view1;
    }
}   // Main Class
