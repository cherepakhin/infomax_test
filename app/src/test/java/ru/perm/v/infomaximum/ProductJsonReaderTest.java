package ru.perm.v.infomaximum;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class ProductJsonReaderTest {

    @Test
    public void readFromNotExistFile() {
        ProductJsonReader reader = new ProductJsonReader();
        Assert.assertThrows(FileNotFoundException.class, () -> reader.readFromFile(""));
    }

    @Test
    public void readArrayFromFile() throws FileNotFoundException {
        String productsJsonFilename = "src/test/resources/out.json";
        ProductJsonReader reader = new ProductJsonReader();
        List<Product> products = reader.readFromFile(productsJsonFilename);
        Assert.assertEquals(4, products.size());
        Assert.assertEquals(new Product("grp1", "type1", 1, 111), products.get(0));
        Assert.assertEquals(new Product("grp1", "type1", 2, 112), products.get(1));
        Assert.assertEquals(new Product("grp2", "type1", 3, 213), products.get(2));
        Assert.assertEquals(new Product("grp2", "type2", 4, 224), products.get(3));
    }
}