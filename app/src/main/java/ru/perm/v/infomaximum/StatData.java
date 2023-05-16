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
    Integer maxWeight = 0;
    /**
     * Минимальный вес продукта в списке продуктов
     */
    Integer minWeight = 0;
    /**
     * Суммарный вес по группе
     */
    Map<String, Integer> sumWegthByGroup = new HashMap<>();
    /**
     * Дубликаты объектов (объекты с одинаковой группой(“group”) и типом (“type”))
     * с количеством их повторений (выводятся только записи, где количество больше одного).
     */
    List<Product> duplicates = new ArrayList<>();
}
