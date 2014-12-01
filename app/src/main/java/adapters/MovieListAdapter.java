package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hplaptop.yifyapi.R;

import models.MovieList;

/**
 * Created by HP LAPTOP on 30-11-2014.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private static MovieList mMovieList;
    private static Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mMovieTitle;
        public ImageView mMovieCover;

        public TextView getmMovieTitle() {
            return mMovieTitle;
        }

        public void setmMovieTitle(TextView mMovieTitle) {
            this.mMovieTitle = mMovieTitle;
        }

        public ViewHolder(View v) {
            super(v);
            mMovieTitle = (TextView) v.findViewById(R.id.movie_title);
            mMovieCover = (ImageView) v.findViewById(R.id.movie_cover);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MovieListAdapter(MovieList myDataset, Context context) {
        mMovieList = myDataset;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        // create a new view
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.movie_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //     viewHolder.mMovieTitle.setText(mMovieList.MovieList.get(position).getMovieTitle());
        //   Picasso.with(mContext).load(mMovieList.MovieList.get(position).getCoverImage()).into(viewHolder.mMovieCover);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        //return mMovieList.MovieList.size();
        return 0;
    }
}




