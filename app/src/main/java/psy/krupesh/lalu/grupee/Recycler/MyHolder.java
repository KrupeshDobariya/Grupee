package psy.krupesh.lalu.grupee.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import psy.krupesh.lalu.grupee.R;

public class MyHolder extends RecyclerView.ViewHolder {

    TextView timeTxt;
    ImageView img;


    public MyHolder(View itemView) {
        super(itemView);

        timeTxt= (TextView) itemView.findViewById(R.id.timeTxt);
        img= (ImageView) itemView.findViewById(R.id.movieImage);

    }
}