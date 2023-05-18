package ru.perm.v.infomaximum.parser.jsonreader;

import org.junit.Test;
import ru.perm.v.infomaximum.data.StatData;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StatByTokenReaderTest {

    @Test
    public void testReadFile() throws IOException {
        StatByTokenReader reader = new StatByTokenReader();
        String productsJsonFilename = "src/test/resources/products_for_test.json";
        StatData statData = reader.parseFile(productsJsonFilename);
    }

    @Test
    public void parsedMaxWeight() {
        StatByTokenReader reader = new StatByTokenReader();
        StatData stat = new StatData();
        stat.setMaxWeight(1);
        reader.setStat(stat);
        assertTrue(reader.parsedIsWeightInLine("\"weight\": 10"));
        assertEquals(new Integer(10), reader.getStat().getMaxWeight());
    }

    @Test
    public void parsedMinWeight() {
        StatByTokenReader reader = new StatByTokenReader();
        StatData stat = new StatData();
        stat.setMinWeight(100);
        reader.setStat(stat);
        assertTrue(reader.parsedIsWeightInLine("\"weight\": 10"));
        assertEquals(new Integer(10), reader.getStat().getMinWeight());
    }
}