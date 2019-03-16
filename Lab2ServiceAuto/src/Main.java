import Domain.ClientValidator;
import Domain.CarValidator;
import Domain.TransactionValidator;
import Repository.ClientRepository;
import Repository.CarRepository;
import Repository.TransactionRepository;
import Service.ClientService;
import Service.CarService;
import Service.TransactionService;
import UI.Console;
import UI.NewConsole;

public class Main {

    public static void main(String[] args) {
            ClientValidator clientValidator = new ClientValidator();
            ClientRepository clientRepository = new ClientRepository(clientValidator);
            ClientService clientService = new ClientService(clientRepository);

            CarValidator carValidator = new CarValidator();
            CarRepository carRepository = new CarRepository(carValidator);
            CarService carService = new CarService(carRepository);

            TransactionValidator transactionValidator = new TransactionValidator();
            TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);
            TransactionService transactionService = new TransactionService(transactionRepository,carRepository,clientRepository);

            NewConsole console = new NewConsole(carService,clientService,transactionService);
            console.run();

    }
}
