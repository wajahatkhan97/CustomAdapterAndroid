package com.example.project2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class ImageAdapter extends BaseAdapter {
    private  Context context;
    private List<Integer> pics;
    TextView txt_view ;

    private List<String> name;
    ImageAdapter(Context c , List<Integer>Id,List<String> name)
    {
        this.context = c;
        this.pics=Id;
        this.name = name;
    }
    @Override
    public int getCount() {

        return pics.size();
    }

    @Override
    public Object getItem(int i) {
        return pics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return pics.get(i);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(context); //created a new view
            grid = inflater.inflate(R.layout.image_text, null);
            TextView textView = (TextView) grid.findViewById(R.id.text_view);
            ImageView imageView = (ImageView)grid.findViewById(R.id.image_view);
           imageView.setPadding(5, 5, 5, 5);
            textView.setText(name.get(i));
            imageView.setImageResource(pics.get(i));
        } else {
            grid = (View) convertView; //recycle view if already exist
        }

        return grid;
    }


}
