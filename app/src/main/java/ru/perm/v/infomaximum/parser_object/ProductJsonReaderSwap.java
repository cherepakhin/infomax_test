package ru.perm.v.infomaximum.parser_object;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import ru.perm.v.infomaximum.data.Product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Собственный парсер JSON
 */
public class ProductJsonReaderSwap {
    public List<Product> readFromFile(String filepath) throws IOException {
// Так не работает с 10 млн
//        JsonReader jsonReader = Json.createReader(new FileReader(filepath));
        List<Product> products = new ArrayList<>();
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser jsonParser = jsonFactory.createParser(new File(filepath));
        JsonToken currentToken;

        currentToken = jsonParser.nextToken();
        if (currentToken != JsonToken.START_OBJECT) {
            System.out.println("Error: root should be object: quiting.");
            throw new IOException("Error: root should be object: quiting.");
        }

        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParser.getCurrentName();
            currentToken = jsonParser.nextToken();
            if (fieldName.equals("records")) {
                if (currentToken == JsonToken.START_ARRAY) {
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
