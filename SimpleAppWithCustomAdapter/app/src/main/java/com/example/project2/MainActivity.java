package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    protected static final String EXTRA_RES_ID = "POS";
  private  ArrayList<Integer> car_pics = new ArrayList<Integer>( //this arraylist contains all the images from drawable using R constant
            Arrays.asList(R.drawable.kiaoptima,R.drawable.nissanaltima,R.drawable.bmwx5,R.drawable.hondacivic,R.drawable.corvettezr1,R.drawable.maseratilevante));
  private ArrayList<String> car_names = new ArrayList<String>(
        Arrays.asList( "Kia Optima", "Nissan Altima", "BMW-X5","Honda Civic", "Corvetter ZR-1","Maserati Levante"));
  private ArrayList<Uri> web_info = new ArrayList<>();
  private TextView txt_view;
  public int position=0;
    public long ID=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); //we have linear layout in constraint layout
//        txt_view = (TextView) findViewById(R.id.my_text_view);
        initialize_array_website();
         GridView grid_view= (GridView)findViewById(R.id.Gview);


        grid_view.setAdapter((new ImageAdapter(this,car_pics,car_names)));
        registerForContextMenu(grid_view); //context menu will automatically recognize the long click //doing this just to get the positions


        //create a menu on long click listener
        //short click
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //registerForContextMenu();
                Intent intent1 = new Intent( MainActivity.this,Imageview.class); //explicit intent
                intent1.putExtra("array",web_info);
                intent1.putExtra("position",position);
                intent1.putExtra(EXTRA_RES_ID,id);
                Log.i("Global ID assigned",Long.toString(id));
                startActivity(intent1);
            }
        });

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);

    }

    private void initialize_array_website()
    {
        web_info.add(Uri.parse("https://www.kia.com/us/en"));
        web_info.add(Uri.parse("https://www.nissanusa.com/"));
        web_info.add(Uri.parse("https://www.bmwusa.com/"));
        web_info.add(Uri.parse("https://www.honda.com/"));
        web_info.add(Uri.parse("https://www.chevrolet.com/performance/corvette"));
        web_info.add(Uri.parse("https://www.maseratiusa.com/us/en"));

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) { //view V is grid_View
            super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
                this.position = info.position;  //setting position to check what item options to show
                this.ID = info.id;
                Log.i("ID1",Long.toString(info.id));
        inflater.inflate(R.menu.context_menu,menu); //taking the layout and setting it to menu
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.entire_pic:
                        //send the putextra to image from long click as well. Right now its not working if you go via long click
                        Intent intent1 = new Intent( MainActivity.this,Imageview.class); //explicit intent
                        intent1.putExtra(EXTRA_RES_ID,this.ID);
                        intent1.putExtra("array",web_info);
                        intent1.putExtra("position",position);
                        Log.i("Global ID assigned",Long.toString(this.ID));
                        startActivity(intent1);
                        break;
                    case R.id.webpage:

                    Intent intent = new Intent(Intent.ACTION_VIEW); //implicit intent
                    intent.setData(web_info.get(this.position));
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    if(intent.resolveActivity(getPackageManager())!=null)
                    {
                        startActivity(intent);
                    }
                    break;
            case R.id.namendaddress: //this will call the third activity
                Intent intent2 = new Intent( MainActivity.this,listview.class); //explicit intent
                intent2.putExtra("dealer_position",this.position);
//                Log.i("Global ID assigned",Long.toString(this.ID));
                startActivity(intent2);
                break;
            default:
                return false;
        }
        return true;
    }

    protected void onDestroy() {

        super.onDestroy();
    }
}