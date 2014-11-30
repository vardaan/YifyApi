package com.example.hplaptop.yifyapi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import adapters.MovieListAdapter;
import api.ApiClient;
import models.Movie;
import retrofit.Callback;
import retrofit.RetrofitError;


public class MovieList extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mMovieAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String TAG = "MovieList";
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mContext = this.getApplicationContext();
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        ApiClient.getMovieListApiClient().getStreams(10, 0, new Callback<List<Movie>>() {


            @Override
            public void success(List<Movie> movies, retrofit.client.Response response) {
                mMovieAdapter = new MovieListAdapter(movies, mContext);
                // specify an adapter (see also next example)
                mRecyclerView.setAdapter(mMovieAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d(TAG, "Try after some time !!!!");
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
