package ru.perm.v.infomaximum;


import org.junit.Test;
import ru.perm.v.infomaximum.data.Product;
import ru.perm.v.infomaximum.parser_object.StatCreatorByListProducts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StatCreatorByProductsTest {

    @Test
    public void testGetMaxWeight() {
        Product product1 = new Product();
        product1.setWeight(111);
        Product product2 = new Product();
        product2.setWeight(222);
        List<Product> productList = Arrays.asList(product1, product2);
        StatCreatorByListProducts statCreatorByProducts = new StatCreatorByListProducts();

        Integer maxWeight = statCreatorByProducts.getMaxWeight(productList);

        assertEquals(Integer.valueOf(222), maxWeight);
    }

    @Test
    public void testGetMinWeight() {
        Product product1 = new Product();
        product1.setWeight(111);
        Product product2 = new Product();
        product2.setWeight(222);
        List<Product> productList = Arrays.asList(product1, product2);
        StatCreatorByListProducts statCreatorByProducts = new StatCreatorByListProducts();

        Integer minWeight = statCreatorByProducts.getMinWeight(productList);

        assertEquals(Integer.valueOf(111), minWeight);
    }

    @Test
    public void testTestGetMaxWeight() {
        String GRP1 = "GRP1";
        Product product11 = new Product();
        product11.setGrp(GRP1);
        product11.setWeight(111);
        Product product12 = new Product();
        product12.setGrp(GRP1);
        product12.setWeight(112);

        String GRP2 = "GRP2";
        Product product21 = new Product();
        product21.setGrp(GRP2);
        product21.setWeight(222);
        Product product22 = new Product();
        product22.setGrp(GRP2);
        product22.setWeight(333);

        List<Product> productList = Arrays.asList(product11, product12, product21, product22);
        StatCreatorByListProducts statCreatorByProducts = new StatCreatorByListProducts();

        Map<String, Integer> weightByGroup = statCreatorByProducts.getSumWegthByGroup(productList);

        assertEquals(Integer.valueOf(223), weightByGroup.get(GRP1));
        assertEquals(Integer.valueOf(555), weightByGroup.get(GRP2));
    }

    @Test
    public void testGetDuplicatesByGrp() {
        String GRP1 = "GRP1";
        String TYPE1 = "TYPE1";

        Product productG1T1N1 = new Product();
        productG1T1N1.setNum(1);
        productG1T1N1.setGrp(GRP1);
        productG1T1N1.setType(TYPE1);

        Product productG1T1N2 = new Product();
        productG1T1N2.setNum(2);
        productG1T1N2.setGrp(GRP1);
        productG1T1N2.setType(TYPE1);

        String GRP2 = "GRP2";
        String TYPE2 = "TYPE2";
        Product productG2T2N3 = new Product();
        productG2T2N3.setNum(3);
        productG2T2N3.setGrp(GRP2);
        productG2T2N3.setType(TYPE2);

        Product productG2T2N4 = new Product();
        productG2T2N4.setNum(4);
        productG2T2N4.setGrp(GRP2);
        productG2T2N4.setType(TYPE2);

        Product otherProduct = new Product();
        otherProduct.setNum(5);
        otherProduct.setGrp("-");
        otherProduct.setType("-");

        List<Product> productList = Arrays.asList(productG1T1N1, productG1T1N2, productG2T2N3, productG2T2N4, otherProduct);
        StatCreatorByListProducts stat = new StatCreatorByListProducts();
        List<Product> duplicates = stat.getDuplicatesByGrpAndType(productList);

        assertEquals(4, duplicates.size());
    }
}