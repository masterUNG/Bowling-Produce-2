package appewtc.masterung.bowlingproduce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by masterUNG on 10/13/2016 AD.
 */

public class VideoAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleString;
    private int[] ints;

    public VideoAdapter(Context context,
                        String[] titleString,
                        int[] ints) {
        this.context = context;
        this.titleString = titleString;
        this.ints = ints;
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
        View view1 = layoutInflater.inflate(R.layout.video_listview, viewGroup, false);

        //Bind Widget
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView12);
        TextView textView = (TextView) view1.findViewById(R.id.textView18);

        //Show View
        textView.setText(titleString[i]);
        imageView.setImageResource(ints[i]);

        return view1;
    }
}   // Main Class
