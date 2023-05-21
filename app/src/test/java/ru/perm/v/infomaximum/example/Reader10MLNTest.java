package ru.perm.v.infomaximum.example;

import org.junit.jupiter.api.Test;
import ru.perm.v.infomaximum.parser.ProductsForTest;

import java.io.*;

public class Reader10MLNTest {
    @Test
    void simpleReadFile() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(ProductsForTest.FILENAME_10000_PRODUCT), 16384);

    }

}
