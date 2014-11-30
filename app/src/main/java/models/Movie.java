package models;

/**
 * Created by HP LAPTOP on 29-11-2014.
 */

import com.google.gson.annotations.Expose;


public class Movie {

    @Expose
    private String MovieTitle;
    @Expose
    private String MovieCover;
    @Expose
    private String ImdbCode;
    @Expose
    private String ImdbLink;
    @Expose
    private String Uploader;
    @Expose
    private String UploaderUID;
    @Expose
    private String DateAdded;
    @Expose
    private int DateAddedEpoch;

    /**
     * @return The MovieTitle
     */
    public String getMovieTitle() {
        return MovieTitle;
    }

    /**
     * @param MovieTitle The MovieTitle
     */
    public void setMovieTitle(String MovieTitle) {
        this.MovieTitle = MovieTitle;
    }

    /**
     * @return The MovieCover
     */
    public String getMovieCover() {
        return MovieCover;
    }

    /**
     * @param MovieCover The MovieCover
     */
    public void setMovieCover(String MovieCover) {
        this.MovieCover = MovieCover;
    }

    /**
     * @return The ImdbCode
     */
    public String getImdbCode() {
        return ImdbCode;
    }

    /**
     * @param ImdbCode The ImdbCode
     */
    public void setImdbCode(String ImdbCode) {
        this.ImdbCode = ImdbCode;
    }

    /**
     * @return The ImdbLink
     */
    public String getImdbLink() {
        return ImdbLink;
    }

    /**
     * @param ImdbLink The ImdbLink
     */
    public void setImdbLink(String ImdbLink) {
        this.ImdbLink = ImdbLink;
    }

    /**
     * @return The Uploader
     */
    public String getUploader() {
        return Uploader;
    }

    /**
     * @param Uploader The Uploader
     */
    public void setUploader(String Uploader) {
        this.Uploader = Uploader;
    }

    /**
     * @return The UploaderUID
     */
    public String getUploaderUID() {
        return UploaderUID;
    }

    /**
     * @param UploaderUID The UploaderUID
     */
    public void setUploaderUID(String UploaderUID) {
        this.UploaderUID = UploaderUID;
    }

    /**
     * @return The DateAdded
     */
    public String getDateAdded() {
        return DateAdded;
    }

    /**
     * @param DateAdded The DateAdded
     */
    public void setDateAdded(String DateAdded) {
        this.DateAdded = DateAdded;
    }

    /**
     * @return The DateAddedEpoch
     */
    public int getDateAddedEpoch() {
        return DateAddedEpoch;
    }

    /**
     * @param DateAddedEpoch The DateAddedEpoch
     */
    public void setDateAddedEpoch(int DateAddedEpoch) {
        this.DateAddedEpoch = DateAddedEpoch;
    }

}