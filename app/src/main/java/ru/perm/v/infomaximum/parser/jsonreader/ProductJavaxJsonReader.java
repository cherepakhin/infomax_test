package ru.perm.v.infomaximum.parser.jsonreader;

import ru.perm.v.infomaximum.data.Product;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductJavaxJsonReader {

    /**
     * Получение списка Product из файла.
     * Падает "java.lang.OutOfMemoryError: Java heap space" с json файлом out10_000_000.json (10 млн. объектов)
     * в JsonReader jsonReader = Json.createReader(new FileReader(filepath));
     * Но РАБОТАЕТ с НЕБОЛЬШИМ json
     *
     * @throws FileNotFoundException - файл не найден
     */
    public List<Product> readFromFile(String filepath) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath), 16384);
        JsonReader jsonReader = Json.createReader(bufferedReader);

        JsonArray productJsonArray = jsonReader.readArray();
        List<Product> products = new ArrayList<>();
        for (JsonObject jsonObject : productJsonArray.getValuesAs(JsonObject.class)) {
            Product product = new Product();
            product.setGrp(jsonObject.getString("grp"));
            product.setType(jsonObject.getString("type"));
            product.setNum(new Long(jsonObject.getString("num")));
            product.setWeight(new Long(jsonObject.asJsonObject().getString("weight")));
            products.add(product);
        }
        return products;
    }
}
