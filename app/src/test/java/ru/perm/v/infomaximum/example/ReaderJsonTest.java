package ru.perm.v.infomaximum.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class ReaderJsonTest {
    //TODO: delete this. Only for test
    // Simple reader JSON
    @Test
    public void readSimpleObjFromJsonString() {
        String replyString = "{\"msg\": \"MSG\", \"pass\": true}";
        JsonReader jsonReader = Json.createReader(new StringReader(replyString));
        JsonObject reply = jsonReader.readObject();
        Boolean pass = reply.getBoolean("pass");
        String msg = reply.getString("msg");
        Assertions.assertEquals("MSG", msg);
        Assertions.assertTrue(pass);
    }
}
