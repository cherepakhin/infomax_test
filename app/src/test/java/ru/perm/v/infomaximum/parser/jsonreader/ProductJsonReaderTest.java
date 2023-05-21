package ru.perm.v.infomaximum.parser.jsonreader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.perm.v.infomaximum.data.Product;

import java.io.FileNotFoundException;
import java.util.List;

import static ru.perm.v.infomaximum.parser.ProductsForTest.FILENAME_PRODUCT_FOR_TEST;
import static ru.perm.v.infomaximum.parser.ProductsForTest.FILENAME_PRODUCT_FOR_TEST_GENERATED;

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

    @Test
    public void readArrayFromGeneratedFile() throws FileNotFoundException {
        ProductJavaxJsonReader reader = new ProductJavaxJsonReader();
        List<Product> products = reader.readFromFile(FILENAME_PRODUCT_FOR_TEST_GENERATED);

        Assertions.assertEquals(5, products.size());
        Assertions.assertEquals(new Product("XuIPdMrUJvaH", "JAtUIEFaiLfCWC", 6691964986978266246L, 1560120833648750892L), products.get(0));
        Assertions.assertEquals(new Product("XuIPdMrUJvaH", "iQMPgIqYumbtK", 9052165176753482402L, 4113726193725328562L), products.get(1));
        Assertions.assertEquals(new Product("BGVDDzLqCEpwsO", "MGYaXrbgGOwOzi", 654471327624459325L, 9150390022749964589L), products.get(2));
        Assertions.assertEquals(new Product("EeEQMnSWJXG", "JjWghKhiVi", 4894075301242225479L, 2735583814329196958L), products.get(3));
        Assertions.assertEquals(new Product("OoAIhpNBjUrTis", "RCgajwfnnEb", 3744019598849545339L, 5022428977080778381L), products.get(4));
    }

    @Disabled
    @Test
    public void readForBigFile_1MLN() throws FileNotFoundException {
        String productsJsonFilename = "src/test/resources/out_1mln.json";
        ProductJavaxJsonReader reader = new ProductJavaxJsonReader();
        List<Product> products = reader.readFromFile(productsJsonFilename);
        Assertions.assertEquals(10000000, products.size());
    }
}