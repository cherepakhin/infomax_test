package ru.perm.v.infomaximum;

import org.junit.Assert;
import org.junit.Test;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReaderJsonTest {
    @Test
    public void readFromString() {
        String replyString = "{\"msg\": \"MSG\", \"pass\": true}";
        JsonReader jsonReader = Json.createReader(new StringReader(replyString));
        JsonObject reply = jsonReader.readObject();
        Boolean pass = reply.getBoolean("pass");
        String msg = reply.getString("msg");
        Assert.assertEquals("MSG", msg);
        Assert.assertTrue(pass);
    }

    @Test
    public void existFile() throws FileNotFoundException {
        FileReader file = new FileReader("src/test/resources/out.json");
        Assert.assertNotNull(file);
    }

    @Test
    public void readArrayFromFile() throws FileNotFoundException {
        JsonReader jsonReader = Json.createReader(new FileReader("src/test/resources/out.json"));
        JsonArray products = jsonReader.readArray();
        Assert.assertEquals(4, products.size());
    }
}
