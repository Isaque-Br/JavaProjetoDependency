package application;

import model.entities.CarRental;
import model.entities.Vehicle;

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

        // Instanciando o objeto rentalService

        sc.close();
    }
}