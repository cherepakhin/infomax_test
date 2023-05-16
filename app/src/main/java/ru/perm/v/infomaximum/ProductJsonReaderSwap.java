package ru.perm.v.infomaximum;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductJsonReaderSwap {
    public List<Product> readFromFile(String filepath) throws IOException {
// Так не работает с 10 млн
//        JsonReader jsonReader = Json.createReader(new FileReader(filepath));
        List<Product> products = new ArrayList<>();
        JsonFactory f = new JsonFactory();
        JsonParser jsonParser = f.createParser(new File(filepath));
        JsonToken current;

        current = jsonParser.nextToken();
        if (current != JsonToken.START_OBJECT) {
            System.out.println("Error: root should be object: quiting.");
            throw new IOException("Error: root should be object: quiting.");
        }

        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParser.getCurrentName();
            current = jsonParser.nextToken();
            if (fieldName.equals("records")) {
                if (current == JsonToken.START_ARRAY) {
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        TreeNode node = jsonParser.readValueAsTree();
                    }
                } else {
                    System.out.println("Error: records should be an array: skipping.");
                    jsonParser.skipChildren();
                }
            } else {
                System.out.println("Unprocessed property: " + fieldName);
                jsonParser.skipChildren();
            }
        }
        return products;
    }
}
