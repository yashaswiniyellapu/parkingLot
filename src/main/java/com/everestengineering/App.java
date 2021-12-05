package com.everestengineering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

final class App {
    private static ParkingLot system;

    public static void main(String[] args) throws IOException {

        Vehicle vehicle;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        do {
            input = reader.readLine().split(" ", -1);
            switch (input[0]) {
                case "create_parking_lot":
                    system = new ParkingLot(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    System.out.println("Created parking lot with" + Integer.parseInt(input[2]) + " floors and " + Integer.parseInt(input[3]) + " slots per floor ");

                    break;
                case "park_vehicle":
                    if (input[1].equalsIgnoreCase("TRUCK")) {
                        vehicle = new Truck(input[2], input[3], SlotType.TRUCK);
                        system.park(vehicle);
                    } else if (input[1].equalsIgnoreCase("BIKE")) {
                        vehicle = new Bike(input[2], input[3], SlotType.BIKE);
                        system.park(vehicle);
                    } else {
                        vehicle = new Car(input[2], input[3],SlotType.CAR);
                        system.park(vehicle);
                    }
                    break;
                case "unpark_vehicle":
                    system.unPark(input[1]);
                    break;
                case "display":
                    if(input[1].contains("free"))
                    {
                        Display display =new DisplayFreeSpace("free",SlotType.valueOf(input[2]));
                        system.display(display);
                    }
                    if(input[1].contains("free"))
                    {
                       Display display= new DisplayOccupiedSpace("occupied",SlotType.valueOf(input[2]));
                       system.display(display);
                    }

                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Enter the valid input");


            }
        } while (!input[0].equals("exit"));
    }
}
