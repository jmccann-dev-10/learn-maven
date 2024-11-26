package us.mn.state.health.example.controller;

import us.mn.state.health.example.constants.ColumnTypes;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CSVBuilder {

    private final Scanner in;
    private final List<String> columnNames = new ArrayList<>();
    private final Map<String, ColumnTypes> columnTypes = new HashMap<>();
    private int numberOfRows;

    public CSVBuilder(Scanner in) {
        this.in = in;
    }

    public void run() {
        //- [ ] I want to be able to specify column names until I give an empty line.
        collectColumnNames();
        //- [ ] I want to be able to specify the type of data for each column.
        collectColumnTypes();
        //- [ ] I want to specify how many rows to be created.
        getNumberRows();
        writeCSV();
    }

    private void collectColumnNames() {
        printTitle("Give Column Names");
        String nextColumn;
        do {
            System.out.println("Number of Columns: " + columnNames.size());
            System.out.println("Current Columns: " + String.join(",", columnNames));
            System.out.print("Next Column (or leave blank to continue): ");
            nextColumn = in.nextLine();
            if (!nextColumn.isEmpty()) {
                columnNames.add(quotify(nextColumn));
            }
        } while (!nextColumn.isEmpty());
    }

    private void collectColumnTypes() {
        printTitle("Give Column Types");
        ColumnTypes[] types = ColumnTypes.values();
        for (String column : columnNames) {
            System.out.println("Please select a type for: " + column);
            for (int i = 0; i < types.length; i++) {
                System.out.printf("\t%s. %s\n", i+1, types[i].getDisplayName());
            }
            int selection = getNextInt(1, types.length);
            columnTypes.put(column, types[selection - 1]);
        }
    }

    private void getNumberRows() {
        System.out.print("How many rows?: ");
        numberOfRows = getNextInt(0, 1000000);
    }

    private void writeCSV() {
        printTitle("Writing Test CSV");
        try(PrintWriter writer = new PrintWriter(new FileOutputStream("example.csv"))) {
            writer.println(String.join(",", columnNames));
            for (int i = 0; i < numberOfRows; i++) {
                String row = columnNames.stream().map(column -> randomizeData(columnTypes.get(column))).collect(Collectors.joining(","));
                writer.println(row);
            }
        } catch (IOException ex) {
            System.out.println("Something went wrong writing the file!");
            ex.printStackTrace();
        }
        System.out.println("Wrote to file: " + quotify("example.csv"));
        printTitle("Done Thanks!");
    }

    private String randomizeData(ColumnTypes columnType) {
        // todo: find something to help with this
        String data = "RANDOM";
        switch (columnType) {
            case FIRST_NAME:
            case LAST_NAME:
            case DATE:
            case STREET_ADDRESS:
            case STATE:
            case ZIP:
        }
        return quotify(data);
    }

    private void printTitle(String title) {
        title = "!!! " + title + " !!!";
        System.out.println(title.toUpperCase());
        System.out.println("=".repeat(title.length()));
    }

    private int getNextInt(int min, int max) {
        Integer nextInt = null;
        do {
            System.out.printf("Please input a valid number (%s, %s): ", min, max);
            String nextLine = in.nextLine();
            if (nextLine.trim().matches("\\d+")) {
                nextInt = Integer.parseInt(nextLine);
            }
        } while (nextInt == null || nextInt < min || nextInt > max);
        return nextInt;
    }

    private String quotify(String toQuote) {
        return "'" + toQuote + "'";
    }
}
