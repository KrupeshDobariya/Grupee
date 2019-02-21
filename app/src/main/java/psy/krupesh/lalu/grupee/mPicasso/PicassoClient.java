package psy.krupesh.lalu.grupee.mPicasso;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoClient {

    //DOWNLOAD AND CACHE IMG
    public static void loadImage(Context c,String url,ImageView img)
    {
        if(url != null && url.length()>0)
        {

            Picasso.get().load(url).into(img);

            // Picasso.with(c).load(url).placeholder(R.drawable.placeholder).into(img);
        }else {

            Picasso.get().load(url).into(img);

          //  Picasso.with(c).load(R.drawable.placeholder).into(img);
        }
    }

}