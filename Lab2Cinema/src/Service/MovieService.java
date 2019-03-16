package Service;

import Domain.Movie;
import Repository.MovieRepository;

import java.util.List;

public class MovieService {
    private MovieRepository repository;

    public MovieService(MovieRepository repository){
        this.repository = repository;
    }

    public void add(String id, String title, int releaseYear, double price, boolean airing){
     Movie movie = new Movie(id, title, releaseYear, price, airing);
     repository.add(movie);
    }

    public void update(String id, String title, int releaseYear, double price, boolean airing){
        Movie movie = new Movie(id, title, releaseYear, price, airing);
        repository.update(movie);
    }

    public void remove(String id){
        repository.remove(id);
    }

    public List<Movie> getAll() {
        return repository.getAll();
    }

}
