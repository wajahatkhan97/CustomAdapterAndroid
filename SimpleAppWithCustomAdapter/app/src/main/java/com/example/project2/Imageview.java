package com.example.project2;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
//this class pull the image on next page

public class Imageview extends AppCompatActivity {
    private ArrayList<Uri> web_info = new ArrayList<>();
    int position=0;
    ImageView img_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent(); // gets the intent used to start the activitiy
        img_view = new ImageView(getApplicationContext());

        img_view.setImageResource((int)intent.getLongExtra(MainActivity.EXTRA_RES_ID,0));
        this.web_info = intent.getParcelableArrayListExtra("array"); //nice parceable take generic arraylist
        this.position = intent.getIntExtra("position",0);
//        img_view.setLayoutParams(new ViewGroup.LayoutParams(1000,1000));
        img_view.setScaleY((float)2);

        setContentView(img_view); //will populate the screen with actual pictures
        //open up the website if user click on the image

        img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call the website of the car using the position send the position here via intent.putExtra("pos",position);
                //and use that position in web.get(position)

                Intent intent = new Intent(Intent.ACTION_VIEW); //implicit intent
                intent.setData(web_info.get(position));
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                if(intent.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(intent);
                }
                Log.i("aha","youclickedme");
            }
        });


    }

//    public void onBackPressed ()
//    {
//        Intent intent = new Intent(Imageview.this,MainActivity.class);//send back to mainactivity on back press
//        startActivity(intent);
//
//    }
//
    protected void onStop() {
        this.img_view = null; //setting the instance of my image view to null so when back button is pressed we can destroy the instance. So, that no more than 1 large picture can be on our Ram at the same time.
        super.onStop();
    }
}
