import Domain.*;
import java.time.LocalDate;
import java.time.LocalTime;

import Repository.*;
import Service.MovieService;
import Service.ClientService;
import Service.ReservationService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Resources/mainWindow.fxml"));
        Parent root = fxmlLoader.load();

        Controller controller = fxmlLoader.getController();

        IValidator<Movie> movieValidator = new MovieValidator();
        IValidator<Client> clientValidator = new ClientValidator();
        IValidator<Reservation> reservationValidator = new ReservationValidator();

        IRepository<Movie> moviesRepository = new JsonFileRepository<>(movieValidator, "movies.json", Movie.class);
        IRepository<Client> cardsRepository = new JsonFileRepository<>(clientValidator, "clients.json", Client.class);
        IRepository<Reservation> bookingsRepository = new JsonFileRepository<>(reservationValidator, "reservations.json", Reservation.class);


        MovieService movieService = new MovieService(moviesRepository,bookingsRepository);
        ClientService clientService = new ClientService(cardsRepository);
        ReservationService reservationService = new ReservationService(bookingsRepository, moviesRepository, cardsRepository);


        controller.setServices(movieService, clientService, reservationService);

        primaryStage.setTitle("Cinema manager");
        primaryStage.setScene(new Scene(root, 1100, 600));
        primaryStage.show();
    }

    //    public void start(Stage primaryStage) throws Exception{
//
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Resources/mainWindow.fxml"));
//        Parent root = fxmlLoader.load();
//
//        Controller controller =  fxmlLoader.getController();
//
//        IValidator<Movie> movieValidator = new MovieValidator();
//        IValidator<Client> clientValidator = new ClientValidator();
//        IValidator<Reservation> reservationValidator = new ReservationValidator();
//
//        IRepository<Movie> movieRepository = new InMemoryRepository<>(movieValidator);
//        IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
//        IRepository<Reservation> reservationRepository = new InMemoryRepository<>(reservationValidator);
//
//        MovieService movieService = new MovieService(MovieRepository, ReservationRepository);
//        movieService.addOrUpdate("1", "Iron Man", 2008, 200, false);
//        movieService.addOrUpdate("2", "Thor", 2011, 250, false);
//        movieService.addOrUpdate("3", "Captain America", 2011, 150, false);
//        movieService.addOrUpdate("4","The Avengers", 2012, 100, false);
//        movieService.addOrUpdate("5","Ant-Man", 2015, 130, true);
//        movieService.addOrUpdate("6","Doctor Strange", 2016, 190, true);
//
//        ClientService clientService = new ClientService(clientRepository);
//        clientService.addOrUpdate("11","Ionut","Mototol", "1234567891012", LocalDate.of(1996,4,4), LocalDate.of(2010,10,10), 0);
//        clientService.addOrUpdate("22","Maria","Palaria", "1234567891013", LocalDate.of(1995,1,5), LocalDate.of(2014,10,10), 0);
//        clientService.addOrUpdate("33","Luna","Maluna", "1234567891014", LocalDate.of(1994,11,23), LocalDate.of(2015,10,10), 0);
//        clientService.addOrUpdate("44","Andrei","Castravete", "1234567891015", LocalDate.of(1978,12,17), LocalDate.of(2018,10,10), 0);
//
//        ReservationService reservationService = new ReservationService(reservationRepository, movieRepository, clientRepository);
//        reservationService.addOrUpdate("111","5","11",LocalDate.of(2019,4,1), LocalTime.of(10,20));
//        reservationService.addOrUpdate("112","6","22",LocalDate.of(2019,3,1), LocalTime.of(11,20));
//        reservationService.addOrUpdate("113","5","11",LocalDate.of(2019,2,1), LocalTime.of(15,20));
//
//        controller.setServices(movieService, clientService, reservationService);
//
//        primaryStage.setTitle("Movie manager");
//        primaryStage.setScene(new Scene(root, 1280, 960));
//
//        primaryStage.show();
//    }


    public static void main(String[] args) {
        launch(args);
    }
}
