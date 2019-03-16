package Service;

import Domain.Reservation;
import Repository.ClientRepository;
import Repository.MovieRepository;
import Repository.ReservationRepository;

import java.util.List;

public class ReservationService {
    private ReservationRepository repository;
    private MovieRepository mrepository;
    private ClientRepository crepository;

    public ReservationService(ReservationRepository repository, MovieRepository mrepository, ClientRepository crepository) {
        this.repository = repository;
        this.mrepository = mrepository;
        this.crepository = crepository;
    }

    public void add(String id, String id_movie, String id_client, String date, String hour){
        Reservation reservation = new Reservation(id, id_movie, id_client, date, hour);
        if (!mrepository.getById(id_movie).isAiring()) {
            throw  new RuntimeException("The movie is not airing!");
        }
        repository.add(reservation);
        crepository.getById(id_client).setPoints(mrepository.getById(id_movie).getBonusPoints());
    }

    public void update(String id, String id_movie, String id_client, String date, String hour){
        Reservation reservation = new Reservation(id, id_movie, id_client, date, hour);

        if (mrepository.getById(id_movie) != null)
        {
            if (!mrepository.getById(id_movie).isAiring())
            {
                throw new RuntimeException(String.format("The movie is not airing"));
            }
        }
        else
        {
            throw new RuntimeException(String.format("There is no movie with that id"));
        }

        repository.update(reservation);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Reservation> getAll() {
        return repository.getAll();
    }
}
