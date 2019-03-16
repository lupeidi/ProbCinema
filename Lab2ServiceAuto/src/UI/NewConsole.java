package UI;
import Domain.Client;
import Domain.Car;
import Domain.Transaction;
import Service.ClientService;
import Service.CarService;
import Service.TransactionService;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;


public class NewConsole {
    private CarService carService;
    private ClientService clientService;
    private TransactionService transactionService;
    private Scanner scanner;

    public NewConsole(CarService carService, ClientService clientService, TransactionService transactionService) {
        this.carService = carService;
        this.clientService = clientService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }


    public void run() {
        while (true) {
            System.out.println("Alegeti optiunea, x pentru exit");
            String option = scanner.nextLine();
            String s[] = null;
            s = option.split(",");

            switch (s[0]) {
                case "addCar":{
                    carService.add( s[1],  s[2],  Integer.parseInt(s[3]),  Integer.parseInt(s[4]), Boolean.parseBoolean(s[5]));
                    break;
                }
                case "add client": {
                    clientService.add(s[1], s[2], s[3], s[4], s[5], s[6]);
                    break;
                }
                case "add transaction": {
                    transactionService.add(s[1], s[2], s[3], Integer.parseInt(s[4]), Integer.parseInt(s[5]), s[6], s[7]);
                    break;
                }
                case "update car":{
                    carService.update( s[1],  s[2],  Integer.parseInt(s[3]),  Integer.parseInt(s[4]), Boolean.parseBoolean(s[5]));
                    break;
                }
                case "update client": {
                    clientService.update(s[1], s[2], s[3], s[4], s[5], s[6]);
                    break;
                }
                case "update transaction": {
                    transactionService.update(s[1], s[2], s[3], Integer.parseInt(s[4]), Integer.parseInt(s[5]), s[6], s[7]);
                    break;
                }
                case "remove car": {
                    carService.remove(s[1]);
                    break;
                }
                case "remove client": {
                    clientService.remove(s[1]);
                    break;
                }
                case "remove transaction": {
                    transactionService.remove(s[1]);
                    break;
                }
                case "show car":{
                    for (Car car : carService.getAll()) {
                        System.out.println(car);
                    }
                    break;
                }
                case "show client":{
                    for (Client client : clientService.getAll()) {
                        System.out.println(client);
                    }
                    break;}
                case "show transaction": {
                    for (Transaction transaction : transactionService.getAll()) {
                        System.out.println(transaction);
                    }
                    break;
                }
                case "x":
                    return;
                default: {
                    System.out.println("Invalid option!");
                    break;
                }
            }
        }
    }
}
