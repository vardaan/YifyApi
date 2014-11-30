package api;

import java.util.List;

import models.Movie;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by HP LAPTOP on 29-11-2014.
 */
public class ApiClient {


    private static MovieListApiInterface sMovieListService;

    public static MovieListApiInterface getMovieListApiClient() {
        if (sMovieListService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://yts.re/api/")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
            sMovieListService = restAdapter.create(MovieListApiInterface.class);
        }
        return sMovieListService;
    }

    public interface MovieListApiInterface {
        @GET("/upcoming.json")
        void getStreams(@Query("limit") int limit, @Query("offset") int offset, Callback<List<Movie>> callback);

        @POST("/register.json")
        void registerUser(@Query("username") String uName, @Query("email") String email,
                          @Query("password") String pass, Callback<String> response);

    }
}
