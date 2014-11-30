package api;

import java.util.List;

import models.LoginResponse;
import models.Movie;
import models.MovieList;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by HP LAPTOP on 29-11-2014.
 */
public class ApiClient {


    private static YifyApiInterface sMovieListService;

    public static YifyApiInterface getYifyApiClient() {
        if (sMovieListService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://yts.re/api/")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
            sMovieListService = restAdapter.create(YifyApiInterface.class);
        }
        return sMovieListService;
    }

    public interface YifyApiInterface {
        @GET("/upcoming.json")
        void getStreams(@Query("limit") int limit, @Query("offset") int offset, Callback<List<Movie>> callback);

        @FormUrlEncoded
        @POST("/register.json")
        void registerUser(@Field("username") String uName, @Field("email") String email,
                          @Field("password") String pass, Callback<String> response);

        @FormUrlEncoded
        @POST("/login.json")
        void LoginUser(@Field("username") String uName,@Field("password") String pass,
                       Callback<LoginResponse> response);

        @GET("/list.json")
        void getMovieList(@Query("limit") int limit, @Query("set") int offset,
                          @Query("quality") String quality,@Query("rating") int rating,
                          @Query("keywords") String keywords,@Query("genre") String genre,
                          @Query("sort") String sort,@Query("order") String order,
                          Callback<List<MovieList>> callback);
    }
}
