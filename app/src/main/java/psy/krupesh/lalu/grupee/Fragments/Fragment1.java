package psy.krupesh.lalu.grupee.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.Objects;

import psy.krupesh.lalu.grupee.Database.DBAdapter;
import psy.krupesh.lalu.grupee.R;

public class Fragment1 extends Fragment {


    private ImageView ivBasicImage;
    private String URL = "https://dog.ceo/api/breeds/image/random";
    private String str;
    private String format;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
      View view =  inflater.inflate(R.layout.fragment1, container, false);


        //Add Codes

        ivBasicImage = (ImageView) view.findViewById(R.id.image);
        Button dislikebtn = view.findViewById(R.id.dislike_button);
        Button likebtn = view.findViewById(R.id.like_button);
        Button btnStart = view.findViewById(R.id.start_activity);

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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    save(format,str);
                }


            }
        });




        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fv = getFragmentManager().beginTransaction();
                fv.replace(R.id.fragment_container,new Fragment2());
                fv.addToBackStack("tag");
                fv.commit();

            }
        });
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void save(String time, String url)
    {
        DBAdapter db= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            db = new DBAdapter(Objects.requireNonNull(getView()).getContext());
        }
        db.openDB();
        db.add(time,url);


        db.closeDB();


    }

    private  void load(){
        RequestQueue requestQueue = Volley.newRequestQueue (getContext());
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
