package rvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrderHistory {

    public static void main(String[] args) {

        String fileName = "../data/order.csv";
        double totalSum = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {

                // Izlaiž virsraksta rindu
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                int orderId = Integer.parseInt(data[0]);
                String customer = data[1];
                String product = data[2];
                int quantity = Integer.parseInt(data[3]);
                double price = Double.parseDouble(data[4]);

                double orderTotal = quantity * price;
                totalSum += orderTotal;

                System.out.printf(
                    "Pasūtījums #%d: %s pasūtīja %d x %s (%.2f EUR) -> Kopā: %.2f EUR%n",
                    orderId, customer, quantity, product, price, orderTotal
                );
            }

            System.out.printf("%nKopējā pasūtījumu summa: %.2f EUR%n", totalSum);

        } catch (IOException e) {
            System.out.println("Kļūda, nolasot failu: " + e.getMessage());
        }
    }
}
