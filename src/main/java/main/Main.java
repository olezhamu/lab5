package main;

import commands.*;
import managers.*;
import utils.*;
import vehicle.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleManager consoleManager = new ConsoleManager();
        new FileManager().readCollection("collection.json");
        consoleManager.start();
    }
}