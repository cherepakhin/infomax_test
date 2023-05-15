package ru.perm.v.infomaximum;

import org.junit.Assert;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductJsonReaderTest {
    private String productsJsonFilename = "src/test/resources/out.json";

    @Test
    public void readArrayFromFile() throws FileNotFoundException {
//        JsonReader jsonReader = Json.createReader(new FileReader(productsJsonFilename));
//        JsonArray products = jsonReader.readArray();
//        products.getValuesAs(jsonValue -> jsonValue.asJsonObject());
//        Assert.assertEquals(4, products.size());
//
//        JsonObject p = products.get(0).asJsonObject();
//        Product product = new Product();
//        product.setGrp(p.getString("grp"));
//        product.setType(p.getString("type"));
//        product.setNum(p.getInt("num"));
//        product.setWeight(p.asJsonObject().getInt("weight"));
//
//        Assert.assertEquals(new Product("grp1", "type1", 1, 111), product);
        ProductJsonReader reader = new ProductJsonReader();
        List<Product> products = reader.readFromFile(productsJsonFilename);
        Assert.assertEquals(4, products.size());
        Assert.assertEquals(new Product("grp1", "type1", 1, 111), products.get(0));
        Assert.assertEquals(new Product("grp1", "type1", 2, 112), products.get(1));
        Assert.assertEquals(new Product("grp2", "type1", 3, 213), products.get(2));
        Assert.assertEquals(new Product("grp2", "type2", 4, 224), products.get(3));
    }
}