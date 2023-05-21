package ru.perm.v.infomaximum.parser.jsonreader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.perm.v.infomaximum.data.Product;

import java.io.FileNotFoundException;
import java.util.List;

import static ru.perm.v.infomaximum.parser.ProductsForTest.FILENAME_PRODUCT_FOR_TEST;

public class ProductJsonReaderTest {

    @Test
    public void readFromNotExistFile() {
        ProductJavaxJsonReader reader = new ProductJavaxJsonReader();
        Assertions.assertThrows(FileNotFoundException.class, () -> reader.readFromFile(""));
    }

    @Test
    public void readArrayFromFile() throws FileNotFoundException {
        ProductJavaxJsonReader reader = new ProductJavaxJsonReader();
        List<Product> products = reader.readFromFile(FILENAME_PRODUCT_FOR_TEST);
        Assertions.assertEquals(4, products.size());
        Assertions.assertEquals(new Product("grp1", "type1", 1L, 111L), products.get(0));
        Assertions.assertEquals(new Product("grp1", "type1", 2L, 112L), products.get(1));
        Assertions.assertEquals(new Product("grp2", "type1", 3L, 213L), products.get(2));
        Assertions.assertEquals(new Product("grp2", "type2", 4L, 224L), products.get(3));
    }

//    @Test
//    public void readForBigFile() throws FileNotFoundException {
//        String productsJsonFilename = "src/test/resources/out10mln.json";
//        ProductJsonReader reader = new ProductJsonReader();
//        List<Product> products = reader.readFromFile(productsJsonFilename);
//        Assert.assertEquals(10000000, products.size());
//    }
}