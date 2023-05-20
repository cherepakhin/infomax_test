package ru.perm.v.infomaximum.parser.gson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.perm.v.infomaximum.data.StatData;

import java.io.IOException;

public class ProductGsonReaderTest {


    @Test
    public void testParseFile() throws IOException {
        ProductGsonReader reader = new ProductGsonReader();
//        String productsJsonFilename = "src/test/resources/products_for_test.json";
        String productsJsonFilename = "src/test/resources/out10000.json";
//        String productsJsonFilename = "src/test/resources/out10mln.json";
        StatData statData = reader.parseFile(productsJsonFilename);
        Assertions.assertEquals(10000, statData.getAllProducts().size());
    }
}