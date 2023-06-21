package org.learning.java.bestoftheyear.controller;

import org.learning.java.bestoftheyear.Movie;
import org.learning.java.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        String name = "filippo";
        model.addAttribute("name", name);
        return "index";
    }
    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "non è un paese per vecchi"));
        movies.add(new Movie(2, "moon holland drive"));
        movies.add(new Movie(3, "memento"));
        movies.add(new Movie(4, "fight club"));
        movies.add(new Movie(5, "the mask"));
        return movies;
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "little wing"));
        songs.add(new Song(2, "Sympaty for the devil "));
        songs.add(new Song(3, "why you only call me when you're high?"));
        songs.add(new Song(4, "piramid song"));
        songs.add(new Song(5, "yes roundbutt"));
        return songs;
    }

    @GetMapping("/movies")
    public String getMovies(Model model){
        List<Movie> moviesList = getBestMovies();
        List<String> movieTitles = new ArrayList<>();
        for (Movie movie : moviesList) {
            if(moviesList.indexOf(movie)==moviesList.size()-1){
                movieTitles.add(movie.getTitle()+".");
            }else {
                movieTitles.add(movie.getTitle());
            }
        }
        model.addAttribute("titles",  movieTitles);
        return "movies";
    }

    @GetMapping("/songs")
    public String getSongs(Model model){
        List<Song> songsList = getBestSongs();
        List<String> songTitles = new ArrayList<>();
        for (Song song : songsList) {
            if(songsList.indexOf(song)==songsList.size()-1){
                songTitles.add(song.getTitle()+".");
            }else {
                songTitles.add(song.getTitle());
            }
        }
        model.addAttribute("titles",  songTitles);
        return "songs";
    }
}




