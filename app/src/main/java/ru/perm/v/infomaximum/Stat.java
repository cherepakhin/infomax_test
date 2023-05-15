package ru.perm.v.infomaximum;

import java.util.*;
import java.util.stream.Collectors;

public class Stat {
    /**
     * Максимальный вес продукта в списке продуктов
     *
     * @param products список продуктов
     * @return максимальный вес
     */
    public Integer getMaxWeight(List<Product> products) {
        return Collections.max(products, Comparator.comparing(p -> p.getWeight())).getWeight();
    }

    /**
     * Минимальный вес продукта в списке продуктов
     *
     * @param products список продуктов
     * @return минимальный вес
     */
    public Integer getMinWeight(List<Product> products) {
        return Collections.min(products, Comparator.comparing(Product::getWeight)).getWeight();
    }

    /**
     * Суммарный вес по группе
     *
     * @param products список продуктов
     * @return Map<String, Integer> где String название группы, Integer - вес
     */
    public Map<String, Integer> getWegthByGroup(List<Product> products) {
        return products.stream().collect(Collectors.groupingBy(Product::getGrp,
                Collectors.summingInt(Product::getWeight)));
    }

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
    List<Product> getDuplicatesByGrpAndType(List<Product> products) {
        Comparator<Product> comparatorByGrpAndType = Comparator
                .comparing(Product::getGrp)
                .thenComparing(Product::getType);
        List<Product> sortedProducts = products.stream()
                .sorted(comparatorByGrpAndType)
                .collect(Collectors.toList());
        String prevGrp = "";
        String prevType = "";
        Product prevProduct = new Product();
        List<Product> ret = new ArrayList<>();
        for (Product currentProduct : sortedProducts) {
            if (currentProduct.getGrp().equals(prevGrp) && currentProduct.getType().equals(prevType)) {
                ret.add(prevProduct);
                ret.add(currentProduct);
            }
            prevGrp = currentProduct.getGrp();
            prevType = currentProduct.getType();
            prevProduct = currentProduct;
        }
        return ret;
    }
}
