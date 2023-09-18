package application;

import model.entities.CarRental;
import model.entities.Invoice;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental data");
        System.out.print("Car model: ");

        String carModel = sc.nextLine();
        System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), formatter);

        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), formatter);

        System.out.print("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();

        System.out.print("Enter price per day: ");
        double pricePerDay = sc.nextDouble();

        // Instanciando o objeto carRental
        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));


        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("INVOICE:");
        System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println();
        System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));



        sc.close();
    }
}