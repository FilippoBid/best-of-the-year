package org.learning.java.bestoftheyear.controller;

import org.learning.java.bestoftheyear.Movie;
import org.learning.java.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("movies",  moviesList);
        return "movies";
    }

    @GetMapping("info/{id}")
    public String infoMovie(@PathVariable Integer id, Model model) {
        Object currentMedia = null;

        for (Movie movie : getBestMovies()) {
            if (movie.getId() == id) {
                currentMedia = movie;
                break;
            }
        }

        if (currentMedia == null) {
            for (Song song : getBestSongs()) {
                if (song.getId() == id) {
                    currentMedia = song;
                    break;
                }
            }
        }


        if (currentMedia instanceof Movie) {
            model.addAttribute("movie", currentMedia);
            return "info";
        } else if (currentMedia instanceof Song) {
            model.addAttribute("song", currentMedia);
            return "info";
        } else {
            return "mediaNotFound";
        }
    }

    @GetMapping("/songs")
    public String getSongs(Model model){
        List<Song> songsList = getBestSongs();
        model.addAttribute("songs",  songsList);
        return "songs";
    }
}




