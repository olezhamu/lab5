package main;

import managers.ConsoleManager;
import utils.CommandContainer;
import vehicle.*;
import vehicle.VehicleType;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.start();
    }
}