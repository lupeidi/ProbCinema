package UI;

import Domain.Client;
import Domain.Movie;
import Domain.Reservation;
import Repository.ReservationRepository;
import Service.MovieService;
import Service.ClientService;
import Service.ReservationService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

    public TableView tableViewMovies;
    public TableColumn tableColumnIdMovie;
    public TableColumn tableColumnNameMovie;
    public TableColumn tableColumnReleaseYear;
    public TableColumn tableColumnPrice;
    public TableColumn tableColumnAiring;
    public Button btnMovieAdd;
    public Button btnMovieDelete;

    public TableView tableViewClients;
    public TableColumn tableColumnIdClient;
    public TableColumn tableColumnFirstName;
    public TableColumn tableColumnLastName;
    public TableColumn tableColumnCNP;
    public TableColumn tableColumnBirthdayDate;
    public TableColumn tableColumnRegistrationDate;
    public TableColumn tableColumnPoints;
    public Button btnClientAdd;
    public Button btnClientDelete;

    public TableView tableViewReservations;
    public TableColumn tableColumnIdReservation;
    public TableColumn tableColumnMovieReservation;
    public TableColumn tableColumnClientReservation;
    public TableColumn tableColumnDate;
    public TableColumn tableColumnHour;
    public Button btnReservationAdd;
    public Button btnReservationDelete;

    private MovieService movieService;
    private ClientService clientService;
    private ReservationService reservationService;

    private ObservableList<Movie> movies = FXCollections.observableArrayList();
    private ObservableList<Client> clients = FXCollections.observableArrayList();
    private ObservableList<Reservation> reservations = FXCollections.observableArrayList();

    public void setServices(MovieService movieService, ClientService clientService, ReservationService reservationService) {
        this.movieService = movieService;
        this.clientService = clientService;
        this.reservationService = reservationService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            movies.addAll(movieService.getAll());
            tableViewMovies.setItems(movies);
            clients.addAll(clientService.getAll());
            tableViewClients.setItems(clients);
            reservations.addAll(reservationService.getAll());
            tableViewReservations.setItems(reservations);
        });
    }

//    public void editMovieName(TableColumn.CellEditEvent cellEditEvent) {
//        Movie editedMovie = (Movie)cellEditEvent.getRowValue();
//        try {
//            String newName = (String)cellEditEvent.getNewValue();
//            movieService.addOrUpdate(editedMovie.getId(), newName, editedMovie.getReleaseYear(), editedMovie.getPrice(), editedMovie.isAiring());
//            editedMovie.setTitle(newName);
//        } catch (RuntimeException rex) {
//            Common.showValidationError(rex.getMessage());
//        }
//        tableViewMovies.refresh();
//    }

//    public void editMovieReleaseYear(TableColumn.CellEditEvent cellEditEvent) {
//        Movie editedMovie = (Movie)cellEditEvent.getRowValue();
//        try {
//            int newYear = (int)cellEditEvent.getNewValue();
//            movieService.addOrUpdate(editedMovie.getId(), editedMovie.getTitle(), newYear, editedMovie.getPrice(), editedMovie.isAiring());
//            editedMovie.setReleaseYear(newYear);
//        } catch (RuntimeException rex) {
//            Common.showValidationError(rex.getMessage());
//        }
//        tableViewMovies.refresh();
//    }

    public void upsertMovie(FXMLLoader fxmlLoader, String text) {
        try {
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle(text);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            MovieAddController controller = fxmlLoader.getController();
            controller.setService(movieService);
            stage.showAndWait();
            movies.clear();
            movies.addAll(movieService.getAll());
        } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window", e);
    }
    }

    public void upsertClient(FXMLLoader fxmlLoader, String text) {
        try {
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle(text);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            ClientAddController controller = fxmlLoader.getController();
            controller.setService(clientService);
            stage.showAndWait();
            clients.clear();
            clients.addAll(clientService.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }

    public void upsertReservation(FXMLLoader fxmlLoader, String text) {
        try {
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle(text);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            ReservationAddController controller = fxmlLoader.getController();
            controller.setService(reservationService);
            stage.showAndWait();
            reservations.clear();
            reservations.addAll(reservationService.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }

    public void btnMovieAddClick(ActionEvent actionEvent) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("movieAdd.fxml"));
            upsertMovie(fxmlLoader, "Add/Update Movie");
    }

    public void btnMovieDeleteClick(ActionEvent actionEvent) {
        Movie selected = (Movie)tableViewMovies.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                movieService.remove(selected.getId());
                movies.clear();
                movies.addAll(movieService.getAll());
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
    }

    public void btnClientAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("clientAdd.fxml"));
        upsertClient(fxmlLoader, "Add/Update Client");
    }

    public void btnClientDeleteClick(ActionEvent actionEvent) {
        Client selected = (Client)tableViewClients.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                clientService.remove(selected.getId());
                clients.clear();
                clients.addAll(clientService.getAll());
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
    }

    public void btnReservationAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("reservationAdd.fxml"));
        upsertReservation(fxmlLoader, "Add/Update Reservation");
    }

    public void btnReservationDeleteClick(ActionEvent actionEvent) {
        Reservation selected = (Reservation) tableViewReservations.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                reservationService.remove(selected.getId());
                reservations.clear();
                reservations.addAll(reservationService.getAll());
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
    }

    public void btnSearchClick (ActionEvent actionEvent) {

    }
//
//    public void btnCancelClick(ActionEvent actionEvent) {
//        Stage stage = (Stage) btnCancel.getScene().getWindow();
//        stage.close();
//    }
}
