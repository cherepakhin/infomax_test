package ru.perm.v.infomaximum.parser.jsonreader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.perm.v.infomaximum.data.StatData;

import java.io.IOException;


public class StatByTokenReaderTest {

    @Test
    public void testReadFile() throws IOException {
        StatByTokenReader reader = new StatByTokenReader();
        String productsJsonFilename = "src/test/resources/products_for_test.json";
        StatData statData = reader.parseFile(productsJsonFilename);
        //TODO
    }

    @Test
    public void parsedMaxWeight() {
        StatByTokenReader reader = new StatByTokenReader();
        StatData stat = new StatData();
        stat.setMaxWeight(1L);
        reader.setStat(stat);
        Assertions.assertEquals(true, reader.parsedIsWeightInLine("\"weight\": 10"));
        Assertions.assertEquals(new Long(10), reader.getStat().getMaxWeight());
    }

    @Test
    public void parsedMinWeight() {
        StatByTokenReader reader = new StatByTokenReader();
        StatData stat = new StatData();
        stat.setMinWeight(100L);
        reader.setStat(stat);
        Assertions.assertEquals(true, reader.parsedIsWeightInLine("\"weight\": 10"));
        Assertions.assertEquals(new Long(10), reader.getStat().getMinWeight());
    }
}