package psy.krupesh.lalu.grupee.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import psy.krupesh.lalu.grupee.Database.DBAdapter;
import psy.krupesh.lalu.grupee.Model.Dog;
import psy.krupesh.lalu.grupee.R;
import psy.krupesh.lalu.grupee.Recycler.MyAdapter;

public class RecyclerMainActivity extends AppCompatActivity {

    ArrayList<Dog> dogs=new ArrayList<>();
    RecyclerView rv;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyler_activity_main);

        //RECYCLERVIEW
        rv= (RecyclerView) findViewById(R.id.myRecyclerID);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        adapter=new MyAdapter(this,dogs);

        retrieve();

    }



    private void retrieve()
    {
        dogs.clear();
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        Cursor c=db.getDogs();
        while (c.moveToNext())
        {
            String time=c.getString(1);
            String url=c.getString(2);

            Dog dog=new Dog();
            dog.setTime(time);
            dog.setImageUrl(url);

            dogs.add(dog);
        }

        if(dogs.size()>0)
        {
            rv.setAdapter(adapter);
        }

        db.closeDB();
    }

}
