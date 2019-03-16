package UI;

import Domain.Client;
import Domain.Car;
import Domain.Transaction;
import Service.ClientService;
import Service.CarService;
import Service.TransactionService;

import java.util.Scanner;

public class Console {
    private CarService carService;
    private ClientService clientService;
    private TransactionService transactionService;
    private Scanner scanner;

    public Console(CarService carService, ClientService clientService, TransactionService transactionService) {
        this.carService = carService;
        this.clientService = clientService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runCars();
                    break;
                case "2":
                    runClients();
                    break;
                case "3":
                    runTransactions();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runCars() {
        while (true) {
            showCarsMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddCar();
                    break;
                case "2":
                    handleUpdateCar();
                    break;
                case "3":
                    handleRemoveCar();
                    break;
                case "4":
                    handleShowAllCars();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void handleShowAllCars() {
        for (Car car : carService.getAll()) {
            System.out.println(car);
        }
    }

    private void handleRemoveCar() {
        try {
            System.out.print("Enter id to remove: ");
            String id = scanner.nextLine();

            carService.remove(id);

            System.out.println("Car removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateCar() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter model to update: ");
            String model = scanner.nextLine();
            System.out.print("Enter year of acquisition to update: ");
            int purchaseYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter number of km to update: ");
            int kmNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter if the car has guarantee (true/false): ");
            boolean guarantee = Boolean.parseBoolean(scanner.nextLine());

            carService.update( id,  model,  purchaseYear,  kmNumber, guarantee);


            System.out.println("Car updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleAddCar() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter model to update: ");
            String model = scanner.nextLine();
            System.out.print("Enter year of acquisition to update: ");
            int purchaseYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter number of km to update: ");
            int kmNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter if the car has guarantee (true/false): ");
            boolean guarantee = Boolean.parseBoolean(scanner.nextLine());

            carService.add( id,  model,  purchaseYear,  kmNumber, guarantee);


            System.out.println("Car added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void showCarsMenu() {
        System.out.println("1. Add car");
        System.out.println("2. Update car");
        System.out.println("3. Remove car");
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
            System.out.print("Enter new birthdayDate: ");
            String birthdayDate = scanner.nextLine();
            System.out.print("Enter new registrationDate: ");
            String registrationDate = scanner.nextLine();

            clientService.add( id,  firstName,  lastName,  cnp,  birthdayDate,  registrationDate);

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
            System.out.print("Enter new birthdayDate: ");
            String birthdayDate = scanner.nextLine();
            System.out.print("Enter new registrationDate: ");
            String registrationDate = scanner.nextLine();

            clientService.update(id, firstName, lastName, cnp, birthdayDate, registrationDate);

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

    private void showTransactionsMenu() {
        System.out.println("1. Add transaction");
        System.out.println("2. Update transaction");
        System.out.println("3. Remove transaction");
        System.out.println("4. Show all");
        System.out.println("x. Back");
    }

    private void runTransactions() {
        while (true) {
            showTransactionsMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddTransaction();
                    break;
                case "2":
                    handleUpdateTransaction();
                    break;
                case "3":
                    handleRemoveTransaction();
                    break;
                case "4":
                    handleShowAllTransactions();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void handleAddTransaction() {
        try {
            System.out.print("Enter new id: ");
            String id = scanner.nextLine();
            System.out.print("Enter car id: ");
            String id_car = scanner.nextLine();
            System.out.print("Enter client id: ");
            String id_client = scanner.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter assembly price: ");
            int assembly = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
            System.out.print("Enter hour: ");
            String hour = scanner.nextLine();

            transactionService.add( id, id_car, id_client, quantity, assembly, date, hour);

            System.out.println("Transaction added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateTransaction() {
        try {
            System.out.print("Enter new id: ");
            String id = scanner.nextLine();
            System.out.print("Enter car id: ");
            String id_car = scanner.nextLine();
            System.out.print("Enter client id: ");
            String id_client = scanner.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter assembly price: ");
            int assembly = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
            System.out.print("Enter hour: ");
            String hour = scanner.nextLine();

            transactionService.update( id, id_car, id_client, quantity, assembly, date, hour);

            System.out.println("Transaction updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleRemoveTransaction() {
        try {
            System.out.print("Enter id to remove: ");
            String id = scanner.nextLine();

            transactionService.remove(id);

            System.out.println("Transaction removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleShowAllTransactions() {
        for (Transaction transaction : transactionService.getAll()) {
            System.out.println(transaction);
        }
    }

    private void showMenu() {
        System.out.println("1. CRUD Cars");
        System.out.println("2. CRUD Clients");
        System.out.println("3. CRUD Transactions");
        System.out.println("x. Exit");
    }
}
