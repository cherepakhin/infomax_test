package ru.perm.v.infomaximum.parser.jsonreader;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.perm.v.infomaximum.data.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class StatCreatorByProductsTest {

    @Test
    public void testGetMaxWeight() {
        Product product1 = new Product();
        product1.setWeight(111L);
        Product product2 = new Product();
        product2.setWeight(222L);
        List<Product> productList = Arrays.asList(product1, product2);
        StatCreatorByListProducts statCreatorByProducts = new StatCreatorByListProducts();

        Long maxWeight = statCreatorByProducts.getMaxWeight(productList);

        Assertions.assertEquals(Long.valueOf(222), maxWeight);
    }

    @Test
    public void testGetMinWeight() {
        Product product1 = new Product();
        product1.setWeight(111L);
        Product product2 = new Product();
        product2.setWeight(222L);
        List<Product> productList = Arrays.asList(product1, product2);
        StatCreatorByListProducts statCreatorByProducts = new StatCreatorByListProducts();

        Long minWeight = statCreatorByProducts.getMinWeight(productList);

        Assertions.assertEquals(Long.valueOf(111), minWeight);
    }

    @Test
    public void testTestGetMaxWeight() {
        String GRP1 = "GRP1";
        Product product11 = new Product();
        product11.setGrp(GRP1);
        product11.setWeight(111L);
        Product product12 = new Product();
        product12.setGrp(GRP1);
        product12.setWeight(112L);

        String GRP2 = "GRP2";
        Product product21 = new Product();
        product21.setGrp(GRP2);
        product21.setWeight(222L);
        Product product22 = new Product();
        product22.setGrp(GRP2);
        product22.setWeight(333L);

        List<Product> productList = Arrays.asList(product11, product12, product21, product22);
        StatCreatorByListProducts statCreatorByProducts = new StatCreatorByListProducts();

        Map<String, Long> weightByGroup = statCreatorByProducts.getSumWegthByGroup(productList);

        Assertions.assertEquals(Long.valueOf(223), weightByGroup.get(GRP1));
        Assertions.assertEquals(Long.valueOf(555), weightByGroup.get(GRP2));
    }

    @Test
    public void testGetDuplicatesByGrp() {
        String GRP1 = "GRP1";
        String TYPE1 = "TYPE1";

        Product productG1T1N1 = new Product();
        productG1T1N1.setNum(1L);
        productG1T1N1.setGrp(GRP1);
        productG1T1N1.setType(TYPE1);

        Product productG1T1N2 = new Product();
        productG1T1N2.setNum(2L);
        productG1T1N2.setGrp(GRP1);
        productG1T1N2.setType(TYPE1);

        String GRP2 = "GRP2";
        String TYPE2 = "TYPE2";
        Product productG2T2N3 = new Product();
        productG2T2N3.setNum(3L);
        productG2T2N3.setGrp(GRP2);
        productG2T2N3.setType(TYPE2);

        Product productG2T2N4 = new Product();
        productG2T2N4.setNum(4L);
        productG2T2N4.setGrp(GRP2);
        productG2T2N4.setType(TYPE2);

        Product otherProduct = new Product();
        otherProduct.setNum(5L);
        otherProduct.setGrp("-");
        otherProduct.setType("-");

        List<Product> productList = Arrays.asList(productG1T1N1, productG1T1N2, productG2T2N3, productG2T2N4, otherProduct);
        StatCreatorByListProducts stat = new StatCreatorByListProducts();
        List<Product> duplicates = stat.getDuplicatesByGrpAndType(productList);

        Assertions.assertEquals(4, duplicates.size());
    }
}