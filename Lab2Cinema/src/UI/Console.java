package UI;

import Domain.Client;
import Domain.Movie;
import Domain.Reservation;
import Service.ClientService;
import Service.MovieService;
import Service.ReservationService;

import java.util.Scanner;

public class Console {
    private MovieService movieService;
    private ClientService clientService;
    private ReservationService reservationService;
    private Scanner scanner;

    public Console(MovieService movieService, ClientService clientService, ReservationService reservationService) {
        this.movieService = movieService;
        this.clientService = clientService;
        this.reservationService = reservationService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMovies();
                    break;
                case "2":
                    runClients();
                    break;
                case "3":
                    runReservations();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }
        }
    }

    private void runMovies() {
        while (true) {
            showMoviesMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddMovie();
                    break;
                case "2":
                    handleUpdateMovie();
                    break;
                case "3":
                    handleRemoveMovie();
                    break;
                case "4":
                    handleShowAllMovies();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleShowAllMovies() {
        for (Movie movie : movieService.getAll()) {
            System.out.println(movie);
        }
    }

    private void handleRemoveMovie() {
        try {
            System.out.print("Enter id to remove: ");
            String id = scanner.nextLine();

            movieService.remove(id);

            System.out.println("Movie removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateMovie() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new release year: ");
            int releaseYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter if the movie is in the program (true/false): ");
            boolean airing = Boolean.parseBoolean(scanner.nextLine());

            movieService.update(id, title, releaseYear, price, airing);


            System.out.println("Movie updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleAddMovie() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new release year: ");
            int releaseYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter if the movie is in the program (true/false): ");
            boolean airing = Boolean.parseBoolean(scanner.nextLine());

            movieService.add(id, title, releaseYear, price, airing);

            System.out.println("Movie added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void showMoviesMenu() {
        System.out.println("1. Add movie");
        System.out.println("2. Update movie");
        System.out.println("3. Remove movie");
        System.out.println("4. Show all");
        System.out.println("x. Back");
    }

    private void showClientsMenu() {
        System.out.println("1. Add client");
        System.out.println("2. Update client");
        System.out.println("3. Remove client");
        System.out.println("4. Show all");
        System.out.println("x. Back");
    }

    private void runClients() {
        while (true) {
            showClientsMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddClient();
                    break;
                case "2":
                    handleUpdateClient();
                    break;
                case "3":
                    handleRemoveClient();
                    break;
                case "4":
                    handleShowAllClients();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleAddClient() {
        try {
            System.out.print("Enter new id: ");
            String id = scanner.nextLine();
            System.out.print("Enter new firstName: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new lastName: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter new cnp: ");
            String cnp = scanner.nextLine();
            System.out.print("Enter new birthdayDate\"dd.MM.yyyy\": ");
            String birthdayDate = scanner.nextLine();
            System.out.print("Enter new registrationDate\"dd.MM.yyyy\": ");
            String registrationDate = scanner.nextLine();

            clientService.add(id, firstName, lastName, cnp, birthdayDate, registrationDate, 0);

            System.out.println("Client added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateClient() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter new firstName: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new lastName: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter new cnp: ");
            String cnp = scanner.nextLine();
            System.out.print("Enter new birthdayDate\"dd.MM.yyyy\": ");
            String birthdayDate = scanner.nextLine();
            System.out.print("Enter new registrationDate\"dd.MM.yyyy\": ");
            String registrationDate = scanner.nextLine();
            System.out.print("Enter new number of points: ");
            int points = Integer.parseInt(scanner.nextLine());

            clientService.update(id, firstName, lastName, cnp, birthdayDate, registrationDate, points);

            System.out.println("Client added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleRemoveClient() {
        try {
            System.out.print("Enter id to remove: ");
            String id = scanner.nextLine();

            clientService.remove(id);

            System.out.println("Client removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleShowAllClients() {
        for (Client client : clientService.getAll()) {
            System.out.println(client);
        }
    }

    private void showReservationsMenu() {
        System.out.println("1. Add reservation");
        System.out.println("2. Update reservation");
        System.out.println("3. Remove reservation");
        System.out.println("4. Show all");
        System.out.println("x. Back");
    }

    private void runReservations() {
        while (true) {
            showReservationsMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddReservation();
                    break;
                case "2":
                    handleUpdateReservation();
                    break;
                case "3":
                    handleRemoveReservation();
                    break;
                case "4":
                    handleShowAllReservations();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleAddReservation() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter movie id: ");
            String id_movie = scanner.nextLine();
            System.out.print("Enter client id: ");
            String id_client = scanner.nextLine();
            System.out.print("Enter date(\"dd.MM.yyyy\"): ");
            String date = scanner.nextLine();
            System.out.print("Enter hour\"hh.mm\": ");
            String hour = scanner.nextLine();

            reservationService.add(id, id_movie, id_client, date, hour);

            System.out.println("Reservation added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateReservation() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter movie id: ");
            String id_movie = scanner.nextLine();
            System.out.print("Enter client id: ");
            String id_client = scanner.nextLine();
            System.out.print("Enter date(\"dd.MM.yyyy\"): ");
            String date = scanner.nextLine();
            System.out.print("Enter hour\"hh.mm\": ");
            String hour = scanner.nextLine();

            reservationService.update(id, id_movie, id_client, date, hour);

            System.out.println("Reservation updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleRemoveReservation() {
        try {
            System.out.print("Enter id to remove: ");
            String id = scanner.nextLine();

            reservationService.remove(id);

            System.out.println("Reservation removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleShowAllReservations() {
        for (Reservation reservation : reservationService.getAll()) {
            System.out.println(reservation);
        }
    }

    private void showMenu() {
        System.out.println("1. CRUD Movies");
        System.out.println("2. CRUD Clients");
        System.out.println("3. CRUD Reservations");
        System.out.println("x. Exit");
    }
}
