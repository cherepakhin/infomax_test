package ru.perm.v.infomaximum;

import java.util.List;
import java.util.Map;

/**
 * Получение статистики на основе списка Product.
 * Не сработает, если список продуктов большой и памяти мало
 */
public interface IStatCreator {
    /**
     * Максимальный вес продукта в списке продуктов
     *
     * @param products список продуктов
     * @return максимальный вес
     */
    Integer getMaxWeight(List<Product> products);
    /**
     * Минимальный вес продукта в списке продуктов
     *
     * @param products список продуктов
     * @return минимальный вес
     */
    Integer getMinWeight(List<Product> products);
    /**
     * Суммарный вес по группе
     *
     * @param products список продуктов
     * @return Map<String, Integer> где String название группы, Integer - вес
     */
    Map<String, Integer> getSumWegthByGroup(List<Product> products);
    /**
     * Дубликаты объектов (объекты с одинаковой группой(“group”) и типом (“type”))
     * с количеством их повторений (выводятся только записи, где количество больше одного).
     * Сортировка:
     * product(grp1,type1,nnum1,weight_nnum1)
     * product(grp1,type1,nnum2,weight_nnum2)
     * <p>
     * product(grp1,type2,nnum3,weight_nnum3)
     * product(grp1,type2,nnum4,weight_nnum4)
     *
     * @param products список продуктов
     * @return список дубликатов
     */
    List<Product> getDuplicatesByGrpAndType(List<Product> products);
}
