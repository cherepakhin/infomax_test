package ru.perm.v.infomaximum.parser.jsonreader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class ProductJavaxJsonReaderTest {

    @Test
    public void readFromFileNotExistFile() {
        ProductJavaxJsonReader reader = new ProductJavaxJsonReader();
        Assertions.assertThrows(FileNotFoundException.class, () -> reader.readFromFile(""));

    }
}