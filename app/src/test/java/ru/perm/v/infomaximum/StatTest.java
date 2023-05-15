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

        List<Product> productList = List.of(product11, product12, product21, product22);
        Stat stat = new Stat();

        Map<String, Integer> weightByGroup = stat.getWegthByGroup(productList);

        assertEquals(Integer.valueOf(223), weightByGroup.get(GRP1));
        assertEquals(Integer.valueOf(555), weightByGroup.get(GRP2));
    }
}