package ru.perm.v.infomaximum.parser.gson;

import com.google.gson.stream.JsonReader;
import ru.perm.v.infomaximum.data.Product;
import ru.perm.v.infomaximum.data.StatData;
import ru.perm.v.infomaximum.parser.util.StatMemory;

import java.io.FileReader;
import java.io.IOException;

public class ProductGsonReader {
    private StatData statData = new StatData();

    public StatData parseFile(String filename) throws IOException {
        long freeMemBefore = StatMemory.getFreeMemory();
        System.out.printf("Free memory before %,d bytes\n", freeMemBefore);
        statData = new StatData();
        try (JsonReader reader = new JsonReader(new FileReader(filename))) {
            reader.beginArray();
            while (reader.hasNext()) {
                Product product = readProduct(reader);
                statData.setMinWeight(product.getWeight());
                statData.getAllProducts().add(product);
            }
            reader.endArray();
        }
        long freeMemAfter = StatMemory.getFreeMemory();
        System.out.printf("Free memory after: %,d bytes, used: %,d bytes\n",
                freeMemAfter, freeMemBefore - freeMemAfter);
        return statData;
    }

    private Product readProduct(JsonReader reader) throws IOException {
        Product product = new Product();
        reader.beginObject();
        while (reader.hasNext()) {
            String fieldName = reader.nextName();
            if (fieldName.equals("group")) {
                product.setGrp(reader.nextString());
                continue;
            }
            if (fieldName.equals("type")) {
                product.setType(reader.nextString());
                continue;
            }
            if (fieldName.equals("number")) {
                product.setNum(reader.nextLong());
                continue;
            }
            if (fieldName.equals("weight")) {
                product.setWeight(reader.nextLong());
            }
        }
        reader.endObject();
        return product;
    }
}
