package ru.perm.v.infomaximum;

import java.util.*;
import java.util.stream.Collectors;

public class Stat {
    /**
     * Максимальный вес продукта в списке продуктов
     * @param products
     * @return
     */
    public Integer getMaxWeight(List<Product> products) {
        return Collections.max(products, Comparator.comparing(p -> p.getWeight())).getWeight();
    }

    /**
     * Минимальный вес продукта в списке продуктов
     * @param products
     * @return
     */
    public Integer getMinWeight(List<Product> products) {
        return Collections.min(products, Comparator.comparing(p -> p.getWeight())).getWeight();
    }

    /**
     * Суммарный вес по группе
     *
     * @param products список продуктов
     * @return Map<String, Integer> где String название группы, Integer - вес
     */
    public Map<String, Integer> getWegthByGroup(List<Product> products) {
        Map<String, Integer> result = products.stream().collect(Collectors.groupingBy(Product::getGrp,
                Collectors.summingInt(Product::getWeight)));
        return result;
    }
}
