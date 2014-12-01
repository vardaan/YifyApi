package com.example.hplaptop.yifyapi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import adapters.MovieListAdapter;
import butterknife.InjectView;


public class MovieListActivity extends ActionBarActivity {
    private static String TAG = "MovieListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list2);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MovieListFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class MovieListFragment extends Fragment {

        @InjectView(R.id.my_recycler_view)
        RecyclerView mRecyclerView;
        private Context mContext;
        private LinearLayoutManager mLayoutManager;
        private MovieListAdapter mMovieAdapter;

        public MovieListFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
            mContext = getActivity().getApplicationContext();
            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(mContext);
            mRecyclerView.setLayoutManager(mLayoutManager);

         /*   ApiClient.getYifyApiClient().getMovieList(10, 0, new Callback<MovieList>() {
                @Override
                public void success(MovieList list, retrofit.client.Response response) {
                    mMovieAdapter = new MovieListAdapter(list, mContext);
                    // specify an adapter (see also next example)
                    mRecyclerView.setAdapter(mMovieAdapter);
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.d(TAG, "Try after some time !!!!");
                }
            });
*/
            return rootView;
        }
    }
}
