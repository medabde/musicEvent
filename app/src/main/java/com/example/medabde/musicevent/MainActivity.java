package com.example.medabde.musicevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import data.CustomListViewAdapter;
import model.Event;

public class MainActivity extends AppCompatActivity {

    private CustomListViewAdapter adapter;
    private ArrayList<Event> events = new ArrayList<>();

    private String urlLeft = "http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=";
    private String urlRight = "&api_key=7fcbaed626a1bd3904f8561e32604fd2&format=json";

    private ListView listView;
    private TextView selectedCity;

    private String url = "http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=spain&api_key=7fcbaed626a1bd3904f8561e32604fd2&format=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);
        adapter= new CustomListViewAdapter(MainActivity.this,R.layout.list_row,events);
        listView.setAdapter(adapter);


        getEvents("paris");


    }

    private void getEvents(String city){
        events.clear();
        String finalUrl = urlLeft+city+urlRight;

        JsonObjectRequest eventRequest = new JsonObjectRequest(Request.Method.GET, finalUrl, (JSONObject) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject eventsObject = response.getJSONObject("topartists");

                    JSONArray eventsArray = eventsObject.getJSONArray("artist");

                    for (int i=0 ;i<eventsArray.length();i++){
                        JSONObject jsonObject = eventsArray.getJSONObject(i);


                        String headLinerText = jsonObject.getString("name");
                        String website = jsonObject.getString("url");

                        Log.i("headLiner : ", headLinerText);
                        Log.i("url : ", website);

                        Event event = new Event();


                        event.setHeadLiner(headLinerText);
                        event.setWebsite(website);

                        events.add(event);


                    }

                    adapter.notifyDataSetChanged();



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(eventRequest);

    }





























}
