import Domain.ClientValidator;
import Domain.MedicamentValidator;
import Domain.TransactionValidator;
import Repository.ClientRepository;
import Repository.MedicamentRepository;
import Repository.TransactionRepository;
import Service.ClientService;
import Service.MedicamentService;
import Service.TransactionService;
import UI.Console;
import UI.NewConsole;

public class Main {

    public static void main(String[] args) {
            ClientValidator clientValidator = new ClientValidator();
            ClientRepository clientRepository = new ClientRepository(clientValidator);
            ClientService clientService = new ClientService(clientRepository);

            MedicamentValidator medicamentValidator = new MedicamentValidator();
            MedicamentRepository medicamentRepository = new MedicamentRepository(medicamentValidator);
            MedicamentService medicamentService = new MedicamentService(medicamentRepository);

            TransactionValidator transactionValidator = new TransactionValidator();
            TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);
            TransactionService transactionService = new TransactionService(transactionRepository, medicamentRepository, clientRepository);

            NewConsole console = new NewConsole(medicamentService,clientService,transactionService);
            console.run();

    }
}
