package ru.perm.v.infomaximum;

import org.junit.Assert;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class ReaderJsonTest {
    @Test
    public void readFromFile() {
        String replyString = "{\"msg\": \"MSG\", \"pass\": true}";
        JsonReader jsonReader = Json.createReader(new StringReader(replyString));
        JsonObject reply = jsonReader.readObject();
        Boolean pass = reply.getBoolean("pass");
        String msg = reply.getString("msg");
        Assert.assertEquals("MSG", msg);
        Assert.assertTrue(pass);
    }
}
