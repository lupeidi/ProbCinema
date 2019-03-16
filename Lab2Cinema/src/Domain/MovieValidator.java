package Domain;

public class MovieValidator {
    public void validate(Movie movie) {
        if (movie.getPrice() <= 0 ){
            throw new RuntimeException("The price must be greater than 0!");
        }
    }
}