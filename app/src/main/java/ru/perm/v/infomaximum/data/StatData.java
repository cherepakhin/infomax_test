package ru.perm.v.infomaximum.data;

import ru.perm.v.infomaximum.data.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Данные статистики
 */
public class StatData {
    private List<Product> allProducts = new ArrayList<>();
    /**
     * Максимальный вес продукта в списке продуктов
     */
    private Long maxWeight = 0L;
    /**
     * Минимальный вес продукта в списке продуктов
     */
    private Long minWeight = 0L;
    /**
     * Суммарный вес по группе
     */
    private Map<String, Long> sumWegthByGroup = new HashMap<>();
    /**
     * Дубликаты объектов (объекты с одинаковой группой(“group”) и типом (“type”))
     * с количеством их повторений (выводятся только записи, где количество больше одного).
     */
    private List<Product> duplicates = new ArrayList<>();

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public Long getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Long maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Long getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Long minWeight) {
        this.minWeight = minWeight;
    }

    public Map<String, Long> getSumWegthByGroup() {
        return sumWegthByGroup;
    }

    public void setSumWegthByGroup(Map<String, Long> sumWegthByGroup) {
        this.sumWegthByGroup = sumWegthByGroup;
    }

    public List<Product> getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(List<Product> duplicates) {
        this.duplicates = duplicates;
    }
}
