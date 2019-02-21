package psy.krupesh.lalu.grupee.Recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import psy.krupesh.lalu.grupee.Model.Dog;
import psy.krupesh.lalu.grupee.R;
import psy.krupesh.lalu.grupee.mPicasso.PicassoClient;

public class MyAdapter  extends RecyclerView.Adapter<MyHolder> {

   Context c;
    ArrayList<Dog> dogs;

    public MyAdapter(Context c, ArrayList<Dog> dogs) {
        this.c = c;
        this.dogs = dogs;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        MyHolder holder=new MyHolder(v);

        return holder;
    }

    //BIND DATA
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
         holder.timeTxt.setText(dogs.get(position).getTime());
        PicassoClient.loadImage(c,dogs.get(position).getImageUrl(),holder.img);
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }
}