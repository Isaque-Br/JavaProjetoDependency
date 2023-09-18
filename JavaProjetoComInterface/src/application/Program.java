package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), formatter);

        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();

        Contract obj = new Contract(number, date, totalValue);

        System.out.print("Enter number of installments: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(null);

        contractService.processContract(obj, n);

        System.out.println("Installments:");
        for (Installment installment : obj.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }
}