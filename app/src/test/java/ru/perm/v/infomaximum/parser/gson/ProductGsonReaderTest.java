package ru.perm.v.infomaximum.parser.gson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.perm.v.infomaximum.data.StatData;
import ru.perm.v.infomaximum.parser.util.StatMemory;

import java.io.IOException;

import static ru.perm.v.infomaximum.parser.ProductsForTest.*;


public class ProductGsonReaderTest {

    @Test
    public void testParseFile_10_000_products() throws IOException {
        long freeMemBefore = StatMemory.getFreeMemory();
        ProductGsonReader reader = new ProductGsonReader();
        StatData statData = reader.parseFile(FILENAME_10000_PRODUCT);
        long freeMemAfter = StatMemory.getFreeMemory();

//      NO MEMORY LIMIT SET!!!
//      Results:
//      Free memory before 210 671 856 bytes
//      Free memory after: 205 386 960 bytes, used: 5 284 896 bytes (5 MB)
        Assertions.assertEquals(10000, statData.getAllProducts().size());
    }

    @Test
    @Disabled
    public void testParseFile_1mln_proucts() throws IOException {
        ProductGsonReader reader = new ProductGsonReader();
        StatData statData = reader.parseFile(FILENAME_1MLN_PRODUCT);
//      NO MEMORY LIMIT SET!!
//      Free memory before 210 673 184 bytes
//      Free memory after: 181 734 320 bytes, used: 28 938 864 bytes (28 MB)
        Assertions.assertEquals(1000000, statData.getAllProducts().size());
    }

    @Disabled
//    Caused by: java.lang.OutOfMemoryError: Java heap space
//    at com.google.gson.stream.JsonReader.nextQuotedValue(JsonReader.java:1014)
    @Test
    public void testParseFile_5mln_proucts() throws IOException {
        ProductGsonReader reader = new ProductGsonReader();
        StatData statData = reader.parseFile(FILENAME_5MLN_PRODUCT);
        Assertions.assertEquals(5000000, statData.getAllProducts().size());
    }


}