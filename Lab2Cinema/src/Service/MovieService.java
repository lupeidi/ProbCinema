package Service;

import Domain.Movie;
import Repository.IRepository;
import Repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private IRepository<Movie> repository;

    public MovieService(IRepository<Movie> repository){
        this.repository = repository;
    }


    public void addOrUpdate(String id, String title, int releaseYear, double price, boolean airing){
        Movie movie = new Movie(id, title, releaseYear, price, airing);
        repository.upsert(movie);
    }

    public void remove(String id){
        repository.remove(id);
    }

    public List<Movie> getAll() {
        return repository.getAll();
    }

    public List<Movie> textSearchMovies(String text) {
        List<Movie> found = new ArrayList<>();
        for ( Movie i: repository.getAll() ) {
            if ((i.getId().contains(text) || i.getTitle().contains(text) || Integer.toString(i.getReleaseYear()).contains(text) || Integer.toString(i.getBookings()).contains(text) || Double.toString(i.getPrice()).contains(text) || Boolean.toString(i.isAiring()).contains(text)) && !found.contains(i)) {
                found.add(i);
            }
        }
        return found;
    }

}
