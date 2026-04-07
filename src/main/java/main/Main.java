package main;

import commands.*;
import managers.*;
import utils.*;
import vehicle.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (!(args.length == 0)) {
            String fileName = args[0];
            new FileManager().readCollection(fileName);
        }
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.start();
    }
}