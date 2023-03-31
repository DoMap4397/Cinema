package fpt.edu.vn.Cinema.controllers;

import fpt.edu.vn.Cinema.models.Movie;
import fpt.edu.vn.Cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class MovieControllers {
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String getAllMovies(ModelMap modelMap) {
        Iterable<Movie> movies = movieRepository.findAll();
        modelMap.addAttribute("movies", movies);
        return "movies";
    }

    @RequestMapping(value = "/movie/add", method = RequestMethod.GET)
    public String addMovie() {
        return "add-new-movie";
    }

    @RequestMapping(value = "/movie/add", method = RequestMethod.POST)
    public String addNewMovie(HttpServletRequest request) {
        Movie movie = new Movie();
        movie.setMovieName(request.getParameter("name"));
        movie.setSmallImageURl(request.getParameter("smallImageUrl"));
        movie.setLargeImageURL(request.getParameter("largeImageURL"));
        movie.setShortDescription(request.getParameter("shortDescription"));
        movie.setLongDescription(request.getParameter("longDescription"));
        movie.setDirector(request.getParameter("director"));
        movie.setActors(request.getParameter("actor"));
        movie.setCategories(request.getParameter("Category"));
        movie.setReleaseDate(LocalDate.parse(request.getParameter("releaseDate").substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        movie.setEndDate(LocalDate.parse(request.getParameter("endDate").substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        movie.setTime(Integer.parseInt(request.getParameter("time")));
        movie.setTrailerURL(request.getParameter("trailerURL"));
        movieRepository.save(movie);
        return "redirect:/movies";
    }
}
