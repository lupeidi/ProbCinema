package Service;

import Domain.Client;
import Domain.Movie;
import Domain.Reservation;
import Repository.ClientRepository;
import Repository.IRepository;
import Repository.MovieRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private IRepository<Reservation>  repository;
    private IRepository<Movie> movieRepository;
    private IRepository<Client> clientRepository;

    public ReservationService(IRepository<Reservation> repository, IRepository<Movie> movieRepository, IRepository<Client>  clientRepository) {
        this.repository = repository;
        this.movieRepository = movieRepository;
        this.clientRepository = clientRepository;
    }

    public void addOrUpdate(String id, String id_movie, String id_client, LocalDate date, LocalTime hour){
        Movie movieToReserve = movieRepository.getById(id_movie);
        Client clientCard = clientRepository.getById(id_client);

        if (movieToReserve == null) {
            throw new RuntimeException("There is no movie with that id.");
        }
        if (!movieToReserve.isAiring()) {
            throw  new RuntimeException("The movie is not airing!");
        }
        Reservation reservation = new Reservation(id, id_movie, id_client, date, hour);

        repository.upsert(reservation);
        movieToReserve.setBookings(movieToReserve.getBookings() + 1);
        if ( clientCard == null ) {
            clientCard.setPoints((int)(clientCard.getPoints() + (movieToReserve.getPrice() / 10)));
        }

    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Reservation> getAll() {
        return repository.getAll();
    }

    public List<Reservation> textSearchReservations(String text) {
        List<Reservation> found = new ArrayList<>();
        for ( Reservation i: repository.getAll() ) {
            if ((i.getId().contains(text) || i.getId_client().contains(text) || i.getId_movie().contains(text) || i.getId_movie().contains(text) ) && !found.contains(i)) {
                found.add(i);
            }
        }
        return found;
    }

    public List<Reservation> periodSearchReservations (LocalTime start, LocalTime end) {
        List<Reservation> found = new ArrayList<>();
        for ( Reservation i: repository.getAll() ) {
            if ( i.getHour().isAfter(start) && i.getHour().isBefore(end)) {
                found.add(i);
            }
        }
        return found;
    }

    public void periodRemoveReservations (LocalDate start, LocalDate end) {
        for ( Reservation i: repository.getAll() ) {
            if ( i.getDate().isAfter(start) && i.getDate().isBefore(end) ) {
                repository.remove((i.getId()));
            }
        }
    }
}
