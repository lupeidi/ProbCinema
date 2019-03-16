import Domain.ClientValidator;
import Domain.MovieValidator;
import Domain.ReservationValidator;
import Repository.ClientRepository;
import Repository.MovieRepository;
import Repository.ReservationRepository;
import Service.ClientService;
import Service.MovieService;
import Service.ReservationService;
import UI.Console;

public class main {
    public static void main(String[] args) {
        ClientValidator cvalidator = new ClientValidator();
        ClientRepository crepository = new ClientRepository(cvalidator);
        ClientService cservice = new ClientService(crepository);

        MovieValidator mvalidator = new MovieValidator();
        MovieRepository mrepository = new MovieRepository(mvalidator);
        MovieService mservice = new MovieService(mrepository);

        ReservationValidator rvalidator = new ReservationValidator();
        ReservationRepository rrepository = new ReservationRepository(rvalidator);
        ReservationService rservice = new ReservationService(rrepository, mrepository, crepository);

        Console console = new Console(mservice,cservice,rservice);
        console.run();
    }
}
