package com.example.Picasso_by_Pro;

import android.app.Activity;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.io.File;



public class MyActivity extends Activity {

    ListView listImage;
    TextView tvView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listImage = (ListView) findViewById(R.id.listImage);
        tvView = (TextView) findViewById(R.id.textView);

        File picture = new File("");


       File[] filesArray = picture.listFiles();




        if(filesArray != null) {
            ImageAdapter  adapter = new ImageAdapter(this, filesArray);
            listImage.setAdapter(adapter);
        }

    }

    static  class ImageAdapter extends ArrayAdapter<File>{

        LayoutInflater inflater;
        Picasso picasso;

        public  ImageAdapter(Context context, File[] objects){
            super(context,R.layout.list_item,objects);

            inflater = LayoutInflater.from(context);
            picasso = Picasso.with(context);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            if(view == null) {
                view = inflater.inflate(R.layout.list_item,parent,false);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView = (TextView) view.findViewById(R.id.textView);
            picasso.load(getItem(position)).resizeDimen(R.dimen.image_size,R.dimen.image_size).centerInside().into(imageView);

            return  view;

        }
    }
}
