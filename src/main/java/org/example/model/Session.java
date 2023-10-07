package org.example.model;

public class Session {
    private Movie movie;
    private Theater theater;

    public Session(Movie movie, Theater theater) {
        this.movie = movie;
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
