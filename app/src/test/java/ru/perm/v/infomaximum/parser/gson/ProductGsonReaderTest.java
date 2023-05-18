package ru.perm.v.infomaximum.parser.gson;

import junit.framework.TestCase;
import ru.perm.v.infomaximum.data.StatData;

import java.io.IOException;

public class ProductGsonReaderTest extends TestCase {

    public void testParseFile() throws IOException {
        ProductGsonReader reader = new ProductGsonReader();
        String productsJsonFilename = "src/test/resources/products_for_test.json";
        StatData statData = reader.parseFile(productsJsonFilename);
        assertEquals(4, statData.getAllProducts().size());
    }
}