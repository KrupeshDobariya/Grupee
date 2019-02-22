package psy.krupesh.lalu.grupee.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import psy.krupesh.lalu.grupee.Database.DBAdapter;
import psy.krupesh.lalu.grupee.Model.Dog;
import psy.krupesh.lalu.grupee.R;
import psy.krupesh.lalu.grupee.Recycler.MyAdapter;


public class Fragment2 extends Fragment {


    ArrayList<Dog> dogs=new ArrayList<>();
    RecyclerView rv;
    MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment2, container, false);
        //RECYCLERVIEW
        rv= (RecyclerView) view.findViewById(R.id.myRecyclerID);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        adapter=new MyAdapter(view.getContext(),dogs);

        retrieve();

        return view;
    }





    private void retrieve()
    {
        dogs.clear();
        DBAdapter db=new DBAdapter(getContext());
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
