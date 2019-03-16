package UI;
import Domain.Client;
import Domain.Medicament;
import Domain.Transaction;
import Service.ClientService;
import Service.MedicamentService;
import Service.TransactionService;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;


public class NewConsole {
    private MedicamentService medicamentService;
    private ClientService clientService;
    private TransactionService transactionService;
    private Scanner scanner;

    public NewConsole(MedicamentService medicamentService, ClientService clientService, TransactionService transactionService) {
        this.medicamentService = medicamentService;
        this.clientService = clientService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }


    public void run() {
        while (true) {
            System.out.println("Alegeti optiunea, x pentru exit");
            String option = scanner.nextLine();
            String s[]=null;
            s = option.split(",");

            switch (s[0]) {
                case "addMedicament":{
                    System.out.println("adaug medicament");
                    medicamentService.add( s[1],  s[2],  s[3],  Double.parseDouble(s[4]), Boolean.parseBoolean(s[5]));
                    break;
                }
                case "add client": {
                    clientService.add(s[1], s[2], s[3], s[4], s[5], s[6]);
                    break;
                }
                case "add transaction": {
                    transactionService.add(s[1], s[2], s[3], Integer.parseInt(s[4]), s[5], s[6]);
                    break;
                }
                case "update medicament":{
                    medicamentService.update(  s[1],  s[2],  s[3],  Double.parseDouble(s[4]), Boolean.parseBoolean(s[5]));
                    break;
                }
                case "update client": {
                    clientService.update(s[1], s[2], s[3], s[4], s[5], s[6]);
                    break;
                }
                case "update transaction": {
                    transactionService.update(s[1], s[2], s[3], Integer.parseInt(s[4]), s[5], s[6]);
                    break;
                }
                case "remove medicament": {
                    medicamentService.remove(s[1]);
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
                case "show medicament":{
                    for (Medicament medicament : medicamentService.getAll()) {
                        System.out.println(medicament);
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
