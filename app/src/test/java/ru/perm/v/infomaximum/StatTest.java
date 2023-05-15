package ru.perm.v.infomaximum;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatTest {

    @Test
    public void testGetMaxWeight() {
        Product product1 = new Product();
        product1.setWeight(111);
        Product product2 = new Product();
        product2.setWeight(222);
        List<Product> productList = List.of(product1, product2);
        Stat stat = new Stat();

        Integer maxWeight = stat.getMaxWeight(productList);

        assertEquals(Integer.valueOf(222), maxWeight);
    }

    @Test
    public void testGetMinWeight() {
        Product product1 = new Product();
        product1.setWeight(111);
        Product product2 = new Product();
        product2.setWeight(222);
        List<Product> productList = List.of(product1, product2);
        Stat stat = new Stat();

        Integer minWeight = stat.getMinWeight(productList);

        assertEquals(Integer.valueOf(111), minWeight);
    }
}