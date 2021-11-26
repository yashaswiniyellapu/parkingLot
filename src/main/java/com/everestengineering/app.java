package com.everestengineering;

import com.everestengineering.design.ParkingLot;
import com.everestengineering.servicetype.Bike;
import com.everestengineering.servicetype.Car;
import com.everestengineering.servicetype.Truck;
import com.everestengineering.servicetype.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

final class app {
    private static ParkingLot system;

    public static void main(String[] args) throws IOException {

        Vehicle vehicle;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] command;
        do {
            command = reader.readLine().split(" ", -1);
            switch (command[0]) {
                case "create_parking_lot":
                    system = new ParkingLot(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                    System.out.println("Created parking lot with" + Integer.parseInt(command[2]) + " floors and " + Integer.parseInt(command[3]) + " slots per floor ");

                    break;
                case "park_vehicle":
                    if (command[1].equalsIgnoreCase("TRUCK")) {
                        vehicle = new Truck(system, command[2], command[3], command[1]);
                        system.park(vehicle);
                    } else if (command[1].equalsIgnoreCase("BIKE")) {
                        vehicle = new Bike(system, command[2], command[3], command[1]);
                        system.park(vehicle);
                    } else {
                        vehicle = new Car(system, command[2], command[3], command[1]);
                        system.park(vehicle);
                    }
                    break;
                case "unpark_vehicle":
                    system.unPark(command[1]);
                    break;
                case "display":
                    system.display(command[1], command[2]);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Enter the valid command");


            }
        } while (!command[0].equals("exit"));
    }
}
