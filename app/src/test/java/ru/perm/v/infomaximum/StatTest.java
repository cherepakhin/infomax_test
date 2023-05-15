package ru.perm.v.infomaximum;


import org.junit.Test;

import java.util.List;
import java.util.Map;

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

    @Test
    public void testTestGetMaxWeight() {
        String GRP1 = "GRP1";
        String GRP2 = "GRP2";
        Product product1 = new Product();
        product1.setGrp(GRP1);
        product1.setWeight(111);
        Product product2 = new Product();
        product2.setGrp(GRP2);
        product2.setWeight(222);
        List<Product> productList = List.of(product1, product2);
        Stat stat = new Stat();

        Map<String, Integer> weightByGroup = stat.getWegthByGroup(productList);

        assertEquals(Integer.valueOf(111), weightByGroup.get(GRP1));
        assertEquals(Integer.valueOf(222), weightByGroup.get(GRP2));
    }
}