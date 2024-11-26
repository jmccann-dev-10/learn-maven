package us.mn.state.health.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import us.mn.state.health.example.controller.CSVBuilder;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @AfterEach
    void cleanUp() {
        File file = new File("example.csv");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void shouldCreateFile() {
        Scanner scanner = new Scanner("test\ntest\ntest\n\n1\n1\n1\n50\n");
        CSVBuilder builder = new CSVBuilder(scanner);
        builder.run();
        assertTrue(new File("example.csv").exists());
    }
}