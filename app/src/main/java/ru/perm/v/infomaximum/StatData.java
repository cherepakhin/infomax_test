package ru.perm.v.infomaximum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Данные статистики
 */
public class StatData {
    /**
     * Максимальный вес продукта в списке продуктов
     */
    private Integer maxWeight = 0;
    /**
     * Минимальный вес продукта в списке продуктов
     */
    private Integer minWeight = 0;
    /**
     * Суммарный вес по группе
     */
    private Map<String, Integer> sumWegthByGroup = new HashMap<>();
    /**
     * Дубликаты объектов (объекты с одинаковой группой(“group”) и типом (“type”))
     * с количеством их повторений (выводятся только записи, где количество больше одного).
     */
    private List<Product> duplicates = new ArrayList<>();

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Integer minWeight) {
        this.minWeight = minWeight;
    }

    public Map<String, Integer> getSumWegthByGroup() {
        return sumWegthByGroup;
    }

    public void setSumWegthByGroup(Map<String, Integer> sumWegthByGroup) {
        this.sumWegthByGroup = sumWegthByGroup;
    }

    public List<Product> getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(List<Product> duplicates) {
        this.duplicates = duplicates;
    }
}
