package ru.perm.v.infomaximum.parser.gson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.perm.v.infomaximum.data.StatData;
import ru.perm.v.infomaximum.parser.util.StatMemory;

import java.io.IOException;

import static ru.perm.v.infomaximum.parser.ProductsForTest.FILENAME_10000_PRODUCT;


public class ProductGsonReaderTest {

    @Test
    public void testParseFile() throws IOException {
        System.out.printf("Free memory before %s\n", StatMemory.getFreeMemory());
        ProductGsonReader reader = new ProductGsonReader();

        StatData statData = reader.parseFile(FILENAME_10000_PRODUCT);
        System.out.printf("Free memory after %s\n", StatMemory.getFreeMemory());
        Assertions.assertEquals(10000, statData.getAllProducts().size());
    }
}