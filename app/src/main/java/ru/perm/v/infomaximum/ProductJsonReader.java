package ru.perm.v.infomaximum;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductJsonReader {

    public List<Product> readFromFile(String filepath) throws FileNotFoundException {
        JsonReader jsonReader = Json.createReader(new FileReader(filepath)); //"src/test/resources/out.json"
        JsonArray productJsonArray = jsonReader.readArray();
        List<Product> products = new ArrayList<>();
        for (JsonObject jsonObject : productJsonArray.getValuesAs(JsonObject.class)) {
            Product product = new Product();
            product.setGrp(jsonObject.getString("grp"));
            product.setType(jsonObject.getString("type"));
            product.setNum(jsonObject.getInt("num"));
            product.setWeight(jsonObject.asJsonObject().getInt("weight"));
            products.add(product);
        }
        return products;
    }
}
