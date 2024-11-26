package us.mn.state.health.example;

import us.mn.state.health.example.controller.CSVBuilder;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CSVBuilder builder = new CSVBuilder(scanner);
        builder.run();
    }
}