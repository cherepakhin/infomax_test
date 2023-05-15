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
            // move from field name to field value
            current = jsonParser.nextToken();
            if (fieldName.equals("records")) {
                if (current == JsonToken.START_ARRAY) {
                    // For each of the records in the array
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        // read the record into a tree model,
                        // this moves the parsing position to the end of it
                        TreeNode node = jsonParser.readValueAsTree();
                        // And now we have random access to everything in the object
//                        System.out.println("field1: " + node.get("field1").getValueAsText());
//                        System.out.println("field2: " + node.get("field2").getValueAsText());
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
//        bufferedReader.readLine(); // пропуск "["
//        while (bufferedReader.read())
//        while (bufferedReader.readLine() != null ){
//
//        };
//        JsonReader jsonReader = Json.createReader(bufferedReader);
//        jsonReader.readObject();
//        Object object = jsonReader.readValue();
//        Object object = jsonReader.readArray();

// Так не работает с 10 млн
//        JsonArray productJsonArray = jsonReader.readArray();
//        for (JsonObject jsonObject : productJsonArray.getValuesAs(JsonObject.class)) {
// если закоммичено, то все равно падает
//            Product product = new Product();
//            product.setGrp(jsonObject.getString("grp"));
//            product.setType(jsonObject.getString("type"));
//            product.setNum(jsonObject.getInt("num"));
//            product.setWeight(jsonObject.asJsonObject().getInt("weight"));
//            products.add(product);
//        }
        return products;
    }
}
