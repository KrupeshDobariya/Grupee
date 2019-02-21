package psy.krupesh.lalu.grupee.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import psy.krupesh.lalu.grupee.Database.DBAdapter;
import psy.krupesh.lalu.grupee.R;

public class MainActivity extends AppCompatActivity {

    private ImageView ivBasicImage;
   private String URL = "https://dog.ceo/api/breeds/image/random";
   private String str;
   private String format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          ivBasicImage = (ImageView) findViewById(R.id.image);
        Button dislikebtn = findViewById(R.id.dislike_button);
        Button likebtn = findViewById(R.id.like_button);
        Button btnStart = findViewById(R.id.start_activity);

        load();

        dislikebtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
                load();


            }
        });
        likebtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
              //  load();
              //  save();
                SimpleDateFormat s = new SimpleDateFormat(" EEEE dd-MM-yyyy hh:mm:ss ");
                format = s.format(new Date());

             load();
             save(format,str);







            }
        });


        btnStart.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here

                startActivity(new Intent(v.getContext(),RecyclerMainActivity.class));
            }
        });

    }


    private void save(String time,String url)
    {
        DBAdapter db=new DBAdapter(this);
        db.openDB();
       db.add(time,url);


        db.closeDB();


    }

    private  void load(){
        RequestQueue requestQueue = Volley.newRequestQueue (getApplicationContext());
        JsonObjectRequest objectRequest  = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                         str = response.optString("message");

                        Picasso.get().load(str).into(ivBasicImage);




                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue.add(objectRequest);

   }





}
