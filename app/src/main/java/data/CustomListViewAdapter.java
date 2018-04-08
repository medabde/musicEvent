package data;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.medabde.musicevent.AppController;
import com.example.medabde.musicevent.R;

import java.util.ArrayList;

import model.Event;

/**
 * Created by Med Abde on 3/22/2018.
 */

public class CustomListViewAdapter extends ArrayAdapter<Event> {
    private LayoutInflater layoutInflater;
    private ArrayList<Event> data;
    private Activity mContext;
    private int layoutRecourceId;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();




    public CustomListViewAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<Event> objects) {
        super(context, resource, objects);

        data = objects;
        mContext = context;
        layoutRecourceId = resource;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Nullable
    @Override
    public Event getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(@Nullable Event item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        ViewHolder viewHolder = null;
        if(row==null){

            layoutInflater = LayoutInflater.from(mContext);
            row = layoutInflater.inflate(layoutRecourceId,parent,false);

            viewHolder = new ViewHolder();


            viewHolder.bandImage = row.findViewById(R.id.bandImage);
            viewHolder.headliner = row.findViewById(R.id.headlinerText);
            viewHolder.venue = row.findViewById(R.id.venueText);
            viewHolder.where = row.findViewById(R.id.whereText);
            viewHolder.when = row.findViewById(R.id.whenText);



            row.setTag(viewHolder);
        }else viewHolder = (ViewHolder) row.getTag();


        viewHolder.event = data.get(position);

        viewHolder.headliner.setText("head liner : " + viewHolder.event.getHeadLiner());
        viewHolder.venue.setText("venue : " + viewHolder.event.getVenueLiner());
        viewHolder.when.setText("when : "+ viewHolder.event.getStartDate());
        viewHolder.where.setText("place : " + viewHolder.event.getStreet()+", " + viewHolder.event.getCity() + ", " + viewHolder.event.getCountry());
        viewHolder.website=viewHolder.event.getWebsite();
        viewHolder.bandImage.setImageUrl(viewHolder.event.getUrl(),imageLoader);




        return row;
    }


    public class ViewHolder{
        Event event;
        NetworkImageView bandImage;
        TextView headliner;
        TextView venue;
        TextView where;
        TextView when;
        String website;



    }
}
